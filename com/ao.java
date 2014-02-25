package com;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.cloudsdk.social.core.util.Weixin;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.handler.ISocialShareHandler;
import com.baidu.cloudsdk.social.share.handler.SocialShareStatisticsManager;
import com.baidu.cloudsdk.social.share.handler.WXMediaMessage;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ao implements ISocialShareHandler {
    private static final String a = ao.class.getSimpleName();
    private static Map b = new HashMap();
    private static Map c = new HashMap();
    private Context d;
    private String e;
    private boolean f;
    private Weixin g;
    private String h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AsyncImageLoader.IAsyncImageLoaderListener {
        private ShareContent b;

        public a(ShareContent shareContent) {
            this.b = shareContent;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
        public void onComplete(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                ao.this.a(this.b, ao.this.a(bitmap));
                return;
            }
            IBaiduListener a = ao.a(ao.this.h);
            ao.b(ao.this.h);
            if (a != null) {
                a.onError(new BaiduException("failed to load image uri "));
            }
        }
    }

    public ao(Context context, String str, boolean z) {
        this.d = context;
        this.e = str;
        this.f = z;
        this.g = new Weixin(context, str);
        this.g.registerApp();
        this.h = a();
    }

    private int a(Bitmap bitmap, int i) {
        return (bitmap.getHeight() * i) / bitmap.getWidth();
    }

    public static IBaiduListener a(String str) {
        WeakReference weakReference = (WeakReference) b.get(str);
        if (weakReference != null) {
            b.remove(str);
            return (IBaiduListener) weakReference.get();
        }
        return null;
    }

    private String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    private void a(Bundle bundle) {
        Weixin.addBaseRequestParams(bundle, this.h, this.f);
        if (this.g.sendRequest(bundle)) {
            return;
        }
        Log.e(a, "sendMessage error");
        IBaiduListener a2 = a(this.h);
        b(this.h);
        if (a2 != null) {
            a2.onError(new BaiduException("failed to start weixin app"));
        }
    }

    private void a(ShareContent shareContent) {
        if (shareContent.getImageData() != null) {
            a(shareContent, a(shareContent.getImageData()), WXMediaMessage.getCompressedImageData(shareContent.getImageData()), false);
        } else if (shareContent.getImageUri() != null) {
            ImageManager.getInstance().loadImage(this.d, shareContent.getImageUri(), new a(shareContent));
        } else {
            a(shareContent, (byte[]) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareContent shareContent, IBaiduListener iBaiduListener) {
        SocialShareConfig socialShareConfig = SocialShareConfig.getInstance(this.d);
        if (!this.g.isAppInstalled()) {
            Toast.makeText(this.d, socialShareConfig.getString("weixin_not_installed"), 1).show();
            if (iBaiduListener != null) {
                iBaiduListener.onError(new BaiduException("weixin not installed yet"));
            }
        } else if (this.f && !this.g.isTimelineSupported()) {
            Toast.makeText(this.d, socialShareConfig.getString("weixin_timeline_not_supported"), 1).show();
            if (iBaiduListener != null) {
                iBaiduListener.onError(new BaiduException("this version of weixin has no support for timeline related api"));
            }
        } else if (!this.f || (shareContent.getWXMediaObjectType() != 8 && shareContent.getWXMediaObjectType() != 6)) {
            a(this.h, iBaiduListener);
            a(this.h, shareContent);
            a(shareContent);
        } else {
            Toast.makeText(this.d, socialShareConfig.getString("weixin_unsupported_mediatype"), 0).show();
            if (iBaiduListener != null) {
                iBaiduListener.onError(new BaiduException("unsupported mediatype for weixin_timeline"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareContent shareContent, byte[] bArr) {
        if (shareContent.getImageUri() != null) {
            a(shareContent, bArr, null, true);
        } else {
            a(shareContent, bArr, null, false);
        }
    }

    private void a(ShareContent shareContent, byte[] bArr, byte[] bArr2, boolean z) {
        WXMediaMessage wXMediaMessage;
        WXMediaMessage.WXEmojiObject wXEmojiObject;
        switch (shareContent.getWXMediaObjectType()) {
            case 1:
                wXMediaMessage = new WXMediaMessage(shareContent.getTitle(), shareContent.getContent(), new WXMediaMessage.WXTextObject(shareContent.getContent()));
                break;
            case 2:
                if (bArr2 == null) {
                    if (!z) {
                        wXMediaMessage = null;
                        break;
                    } else {
                        WXMediaMessage.WXImageObject wXImageObject = new WXMediaMessage.WXImageObject();
                        if (!Utils.isUrl(shareContent.getImageUri())) {
                            String realPathFromUri = Utils.getRealPathFromUri((Activity) this.d, shareContent.getImageUri());
                            if (!TextUtils.isEmpty(realPathFromUri)) {
                                wXImageObject.setImagePath(realPathFromUri);
                                wXMediaMessage = new WXMediaMessage(wXImageObject);
                                break;
                            } else {
                                wXMediaMessage = null;
                                break;
                            }
                        } else {
                            wXImageObject.setImageUrl(shareContent.getImageUri().toString());
                            wXMediaMessage = new WXMediaMessage(wXImageObject);
                            break;
                        }
                    }
                } else {
                    wXMediaMessage = new WXMediaMessage(new WXMediaMessage.WXImageObject(bArr2));
                    break;
                }
            case 3:
            case 4:
            case 5:
            case 7:
            default:
                wXMediaMessage = new WXMediaMessage(shareContent.getTitle(), shareContent.getContent(), new WXMediaMessage.WXWebpageObject(shareContent.getLinkUrl()));
                break;
            case 6:
                wXMediaMessage = new WXMediaMessage((shareContent.getWXMediaContent() == null || shareContent.getWXMediaContent().length == 0) ? new WXMediaMessage.WXFileObject(shareContent.getWXMediaContentPath()) : new WXMediaMessage.WXFileObject(shareContent.getWXMediaContent()));
                break;
            case 8:
                if (shareContent.getWXMediaContent() == null || shareContent.getWXMediaContent().length == 0) {
                    wXEmojiObject = new WXMediaMessage.WXEmojiObject(shareContent.getWXMediaContentPath());
                } else {
                    wXEmojiObject = new WXMediaMessage.WXEmojiObject(shareContent.getWXMediaContent());
                    bArr = shareContent.getWXMediaContent();
                }
                wXMediaMessage = new WXMediaMessage(wXEmojiObject);
                break;
        }
        if (wXMediaMessage == null) {
            Log.e(a, "can't new WXMessage");
            IBaiduListener a2 = a(this.h);
            b(this.h);
            if (a2 != null) {
                a2.onError(new BaiduException("WXMessage can't new instance"));
                return;
            }
            return;
        }
        if (bArr != null) {
            wXMediaMessage.setThumbImage(bArr);
        }
        if (wXMediaMessage.a()) {
            a(wXMediaMessage.toBundle());
            return;
        }
        Log.e(a, "sendMessage error");
        IBaiduListener a3 = a(this.h);
        b(this.h);
        if (a3 != null) {
            a3.onError(new BaiduException("WXMessage args error pls check args!"));
        }
    }

    private static void a(String str, IBaiduListener iBaiduListener) {
        b.put(str, new WeakReference(iBaiduListener));
    }

    private static void a(String str, ShareContent shareContent) {
        c.put(str, new WeakReference(shareContent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(Bitmap bitmap) {
        int i;
        int i2 = SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED;
        if (bitmap != null) {
            if (bitmap.getWidth() >= bitmap.getHeight()) {
                i = a(bitmap, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
            } else {
                i2 = b(bitmap, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
                i = 150;
            }
            if (bitmap.getWidth() == i2 && bitmap.getHeight() == i) {
                return WXMediaMessage.getCompressedImageData(bitmap);
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i, true);
            byte[] compressedImageData = WXMediaMessage.getCompressedImageData(createScaledBitmap);
            createScaledBitmap.recycle();
            return compressedImageData;
        }
        return null;
    }

    private int b(Bitmap bitmap, int i) {
        return (bitmap.getWidth() * i) / bitmap.getHeight();
    }

    public static ShareContent b(String str) {
        WeakReference weakReference = (WeakReference) c.get(str);
        if (weakReference != null) {
            c.remove(str);
            return (ShareContent) weakReference.get();
        }
        return null;
    }

    @Override // com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        Toast.makeText(this.d, SocialShareConfig.getInstance(this.d).getString("pls_waiting"), 0).show();
        MediaType mediaType = MediaType.WEIXIN;
        if (this.f) {
            mediaType = MediaType.WEIXIN_TIMELINE;
        }
        SocialShareStatisticsManager.getInstance(this.d).getBackUrl(shareContent.getLinkUrl(), mediaType.toString(), new ap(this, shareContent, iBaiduListener));
    }
}
