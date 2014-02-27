package com.baidu.cloudsdk.social.share.handler;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import com.baidu.cloudsdk.common.util.Validator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public final class WXMediaMessage {
    private static final String a = WXMediaMessage.class.getSimpleName();
    private String b;
    private String c;
    private byte[] d;
    private IMediaObject e;

    /* loaded from: classes.dex */
    public interface IMediaObject {
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;

        boolean checkArgs();

        String identifier();

        void serialize(Bundle bundle);

        int type();
    }

    /* loaded from: classes.dex */
    public class WXEmojiObject implements IMediaObject {
        public byte[] emojiData;
        public String emojiPath;

        public WXEmojiObject() {
            this.emojiData = null;
            this.emojiPath = null;
        }

        public WXEmojiObject(String str) {
            this.emojiPath = str;
        }

        public WXEmojiObject(byte[] bArr) {
            this.emojiData = bArr;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public boolean checkArgs() {
            int i;
            if ((this.emojiData == null || this.emojiData.length == 0) && (this.emojiPath == null || this.emojiPath.length() == 0)) {
                Log.e(WXMediaMessage.a, "checkArgs fail, both arguments is null");
                return false;
            } else if (this.emojiData != null && this.emojiData.length > 10485760) {
                Log.e(WXMediaMessage.a, "checkArgs fail, emojiData is too large");
                return false;
            } else {
                if (this.emojiPath != null) {
                    String str = this.emojiPath;
                    if (str == null || str.length() == 0) {
                        i = 0;
                    } else {
                        File file = new File(str);
                        i = file.exists() ? (int) file.length() : 0;
                    }
                    if (i > 10485760) {
                        Log.e(WXMediaMessage.a, "checkArgs fail, emojiSize is too large");
                        return false;
                    }
                }
                return true;
            }
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public String identifier() {
            return "com.tencent.mm.sdk.openapi.WXEmojiObject";
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public void serialize(Bundle bundle) {
            bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
            bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
        }

        public void setEmojiData(byte[] bArr) {
            this.emojiData = bArr;
        }

        public void setEmojiPath(String str) {
            this.emojiPath = str;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public int type() {
            return 8;
        }

        public void unserialize(Bundle bundle) {
            this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
            this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
        }
    }

    /* loaded from: classes.dex */
    public class WXFileObject implements IMediaObject {
        public byte[] fileData;
        public String filePath;

        public WXFileObject() {
            this.fileData = null;
            this.filePath = null;
        }

        public WXFileObject(String str) {
            this.filePath = str;
        }

        public WXFileObject(byte[] bArr) {
            this.fileData = bArr;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public boolean checkArgs() {
            int i;
            if ((this.fileData == null || this.fileData.length == 0) && (this.filePath == null || this.filePath.length() == 0)) {
                Log.e(WXMediaMessage.a, "checkArgs fail, both arguments is null");
                return false;
            } else if (this.fileData != null && this.fileData.length > 10485760) {
                Log.e(WXMediaMessage.a, "checkArgs fail, fileData is too large");
                return false;
            } else {
                if (this.filePath != null) {
                    String str = this.filePath;
                    if (str == null || str.length() == 0) {
                        i = 0;
                    } else {
                        File file = new File(str);
                        i = file.exists() ? (int) file.length() : 0;
                    }
                    if (i > 10485760) {
                        Log.e(WXMediaMessage.a, "checkArgs fail, fileSize is too large");
                        return false;
                    }
                }
                return true;
            }
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public String identifier() {
            return "com.tencent.mm.sdk.openapi.WXFileObject";
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public void serialize(Bundle bundle) {
            bundle.putByteArray("_wxfileobject_fileData", this.fileData);
            bundle.putString("_wxfileobject_filePath", this.filePath);
        }

        public void setFileData(byte[] bArr) {
            this.fileData = bArr;
        }

        public void setFilePath(String str) {
            this.filePath = str;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public int type() {
            return 6;
        }

        public void unserialize(Bundle bundle) {
            this.fileData = bundle.getByteArray("_wxfileobject_fileData");
            this.filePath = bundle.getString("_wxfileobject_filePath");
        }
    }

    /* loaded from: classes.dex */
    public class WXImageObject implements IMediaObject {
        public byte[] mImageData;
        public String mImagePath;
        public String mImageUrl;

        public WXImageObject() {
        }

        public WXImageObject(byte[] bArr) {
            this.mImageData = bArr;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public boolean checkArgs() {
            int i;
            if ((this.mImageData == null || this.mImageData.length == 0) && ((this.mImagePath == null || this.mImagePath.length() == 0) && (this.mImageUrl == null || this.mImageUrl.length() == 0))) {
                Log.e(WXMediaMessage.a, "checkArgs fail, all arguments are null");
                return false;
            } else if (this.mImageData != null && this.mImageData.length > 10485760) {
                Log.e(WXMediaMessage.a, "checkArgs fail, content is too large");
                return false;
            } else if (this.mImagePath != null && this.mImagePath.length() > 10240) {
                Log.e(WXMediaMessage.a, "checkArgs fail, path is invalid");
                return false;
            } else {
                if (this.mImagePath != null) {
                    String str = this.mImagePath;
                    if (str == null || str.length() == 0) {
                        i = 0;
                    } else {
                        File file = new File(str);
                        i = file.exists() ? (int) file.length() : 0;
                    }
                    if (i > 10485760) {
                        Log.e(WXMediaMessage.a, "checkArgs fail, image content is too large");
                        return false;
                    }
                }
                if (this.mImageUrl == null || this.mImageUrl.length() <= 10240) {
                    return true;
                }
                Log.e(WXMediaMessage.a, "checkArgs fail, url is invalid");
                return false;
            }
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public String identifier() {
            return "com.tencent.mm.sdk.openapi.WXImageObject";
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public void serialize(Bundle bundle) {
            bundle.putByteArray("_wximageobject_imageData", this.mImageData);
            bundle.putString("_wximageobject_imagePath", this.mImagePath);
            bundle.putString("_wximageobject_imageUrl", this.mImageUrl);
        }

        public void setImagePath(String str) {
            this.mImagePath = str;
        }

        public void setImageUrl(String str) {
            this.mImageUrl = str;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public int type() {
            return 2;
        }
    }

    /* loaded from: classes.dex */
    public class WXTextObject implements IMediaObject {
        public String text;

        public WXTextObject() {
            this(null);
        }

        public WXTextObject(String str) {
            this.text = str;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public boolean checkArgs() {
            if (this.text == null || this.text.length() == 0 || this.text.length() > 10240) {
                Log.e(WXMediaMessage.a, "checkArgs fail, text is invalid");
                return false;
            }
            return true;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public String identifier() {
            return "com.tencent.mm.sdk.openapi.WXTextObject";
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public void serialize(Bundle bundle) {
            bundle.putString("_wxtextobject_text", this.text);
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public int type() {
            return 1;
        }

        public void unserialize(Bundle bundle) {
            this.text = bundle.getString("_wxtextobject_text");
        }
    }

    /* loaded from: classes.dex */
    public class WXWebpageObject implements IMediaObject {
        private String a;

        public WXWebpageObject(String str) {
            this.a = str;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public boolean checkArgs() {
            if (this.a == null || this.a.length() == 0 || this.a.length() > 10240) {
                Log.e(WXMediaMessage.a, "checkArgs fail, webpageUrl is invalid");
                return false;
            }
            return true;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public String identifier() {
            return "com.tencent.mm.sdk.openapi.WXWebpageObject";
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public void serialize(Bundle bundle) {
            Validator.notNull(bundle, "bundle");
            bundle.putString("_wxwebpageobject_webpageUrl", this.a);
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public int type() {
            return 5;
        }
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.e = iMediaObject;
    }

    public WXMediaMessage(String str, String str2, IMediaObject iMediaObject) {
        this.b = str;
        this.c = str2;
        this.e = iMediaObject;
    }

    public static byte[] getCompressedImageData(Bitmap bitmap) {
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            r0 = bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream) ? byteArrayOutputStream.toByteArray() : null;
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
        }
        return r0;
    }

    public final boolean a() {
        if (getType() == 8 && (this.d == null || this.d.length == 0)) {
            Log.e(a, "checkArgs fail, thumbData should not be null when send emoji");
            return false;
        } else if (this.d != null && this.d.length > 65536) {
            Log.e(a, "checkArgs fail, thumbData is invalid");
            return false;
        } else if (this.b != null && this.b.length() > 512) {
            Log.e(a, "checkArgs fail, title is invalid");
            return false;
        } else if (this.c != null && this.c.length() > 1024) {
            Log.e(a, "checkArgs fail, description is invalid");
            return false;
        } else if (this.e == null) {
            Log.e(a, "checkArgs fail, mediaObject is null");
            return false;
        } else {
            return this.e.checkArgs();
        }
    }

    public final int getType() {
        if (this.e != null) {
            return this.e.type();
        }
        return 0;
    }

    public final WXMediaMessage setDesc(String str) {
        this.c = str;
        return this;
    }

    public final WXMediaMessage setThumbImage(byte[] bArr) {
        this.d = bArr;
        return this;
    }

    public final WXMediaMessage setTitle(String str) {
        this.b = str;
        return this;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("_wxobject_sdkVer", 553844737);
        bundle.putString("_wxobject_title", this.b);
        bundle.putString("_wxobject_description", this.c);
        bundle.putByteArray("_wxobject_thumbdata", this.d);
        if (this.e != null) {
            bundle.putString("_wxobject_identifier_", this.e.identifier());
            this.e.serialize(bundle);
        }
        return bundle;
    }
}
