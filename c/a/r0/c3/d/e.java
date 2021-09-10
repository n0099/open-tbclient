package c.a.r0.c3.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.sina.weibo.sdk.utils.Utility;
/* loaded from: classes3.dex */
public class e extends c.a.r0.c3.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ShareEntity f16534h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.c3.e.b f16535i;

    /* renamed from: j  reason: collision with root package name */
    public WbShareHandler f16536j;
    public WbShareCallback k;
    public final c.a.e.e.l.c<c.a.e.l.d.a> l;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f16537a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16537a = eVar;
        }

        @Override // c.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.f16537a.f16535i != null) {
                    this.f16537a.f16535i.onShare(6, 3);
                }
                this.f16537a.w(3, 6);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                super.onLoaded((a) aVar, str, i2);
                if (aVar != null) {
                    Bitmap p = aVar.p();
                    e eVar = this.f16537a;
                    eVar.L(eVar.f16534h, p);
                    return;
                }
                e eVar2 = this.f16537a;
                eVar2.L(eVar2.f16534h, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Activity activity, c.a.r0.c3.e.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, bVar, wbShareCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f16522b = activity;
        this.f16535i = bVar;
        this.k = wbShareCallback;
        WbShareHandler wbShareHandler = new WbShareHandler(activity);
        this.f16536j = wbShareHandler;
        if (wbShareHandler != null) {
            wbShareHandler.registerApp();
        }
    }

    public final String C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    public final ImageObject D(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
            ImageObject imageObject = new ImageObject();
            imageObject.setThumbImage(i(bitmap, 120));
            imageObject.setImageObject(bitmap);
            return imageObject;
        }
        return (ImageObject) invokeL.objValue;
    }

    public final WebpageObject E(Bitmap bitmap, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, bitmap, str, str2, str3)) == null) {
            if (bitmap == null) {
                return null;
            }
            WebpageObject webpageObject = new WebpageObject();
            webpageObject.setThumbImage(bitmap);
            webpageObject.identify = Utility.generateGUID();
            webpageObject.title = C(str);
            webpageObject.description = C(str2);
            webpageObject.actionUrl = C(str3);
            return webpageObject;
        }
        return (WebpageObject) invokeLLLL.objValue;
    }

    public final WebpageObject F(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bArr, str)) == null) {
            if (bArr == null) {
                return null;
            }
            WebpageObject webpageObject = new WebpageObject();
            webpageObject.thumbData = bArr;
            webpageObject.identify = Utility.generateGUID();
            webpageObject.title = "";
            webpageObject.description = "";
            webpageObject.actionUrl = C(str);
            return webpageObject;
        }
        return (WebpageObject) invokeLL.objValue;
    }

    public final TextObject G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f16534h == null) {
                return null;
            }
            TextObject textObject = new TextObject();
            textObject.title = C(this.f16534h.getTitle());
            textObject.text = C(this.f16534h.topic) + C(this.f16534h.getContent());
            return textObject;
        }
        return (TextObject) invokeV.objValue;
    }

    public final WebpageObject H(WeiboMultiMessage weiboMultiMessage, ShareEntity shareEntity, Bitmap bitmap) {
        InterceptResult invokeLLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, weiboMultiMessage, shareEntity, bitmap)) == null) {
            byte[] bArr2 = null;
            if (weiboMultiMessage != null && shareEntity != null) {
                String linkUrl = shareEntity.getLinkUrl();
                if (TextUtils.isEmpty(linkUrl)) {
                    return null;
                }
                if (weiboMultiMessage.textObject != null) {
                    ImageObject imageObject = weiboMultiMessage.imageObject;
                    if (imageObject != null && (bArr = imageObject.thumbData) != null) {
                        bArr2 = bArr;
                    } else if (bitmap != null) {
                        bArr2 = BitmapHelper.Bitmap2Bytes(i(bitmap, 120), 100);
                    }
                    return F(bArr2, linkUrl);
                } else if (bitmap != null) {
                    return E(i(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
                }
            }
            return null;
        }
        return (WebpageObject) invokeLLL.objValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.r0.c3.e.b bVar = this.f16535i;
            if (bVar != null) {
                bVar.onShare(6, 3);
            }
            w(3, 6);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.r0.c3.e.b bVar = this.f16535i;
            if (bVar != null) {
                bVar.onShare(6, 2);
            }
            w(2, 6);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.c3.e.b bVar = this.f16535i;
            if (bVar != null) {
                bVar.onShare(6, 1);
            }
            w(1, 6);
        }
    }

    public final void L(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, shareEntity, bitmap) == null) {
            if (this.f16534h != null && this.f16536j != null && (this.f16522b instanceof Activity)) {
                WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
                if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
                    weiboMultiMessage.textObject = G();
                }
                if (bitmap != null) {
                    weiboMultiMessage.imageObject = D(bitmap);
                }
                WebpageObject H = H(weiboMultiMessage, shareEntity, bitmap);
                if (H != null) {
                    weiboMultiMessage.mediaObject = H;
                }
                this.f16536j.shareMessage(weiboMultiMessage, false);
                return;
            }
            c.a.r0.c3.e.b bVar = this.f16535i;
            if (bVar != null) {
                bVar.onShare(6, 2);
            }
            w(2, 6);
        }
    }

    @Override // c.a.r0.c3.e.a
    public void a(ShareEntity shareEntity, c.a.r0.c3.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, shareEntity, bVar) == null) {
            if (shareEntity != null && this.f16536j != null) {
                this.f16534h = shareEntity;
                this.f16535i = bVar;
                c.a.e.l.d.a o = o(shareEntity);
                if (o != null && o.p() != null) {
                    L(this.f16534h, o.p());
                    return;
                }
                String imgUrl = shareEntity.getImgUrl();
                if (n(shareEntity.getLocalFile())) {
                    L(this.f16534h, g(shareEntity.getLocalFile()));
                    return;
                } else if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                    c.a.e.e.l.d.h().k(imgUrl, 10, this.l, 0, 0, h(), new Object[0]);
                    return;
                } else if (m(shareEntity.getImageUri())) {
                    L(this.f16534h, f(shareEntity.getImageUri()));
                    return;
                } else {
                    L(this.f16534h, d());
                    return;
                }
            }
            w(2, 6);
            if (bVar != null) {
                bVar.onShare(6, 2);
            }
        }
    }

    @Override // c.a.r0.c3.d.a
    public void l(Intent intent) {
        WbShareHandler wbShareHandler;
        WbShareCallback wbShareCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, intent) == null) || (wbShareHandler = this.f16536j) == null || (wbShareCallback = this.k) == null) {
            return;
        }
        wbShareHandler.doResultIntent(intent, wbShareCallback);
        if (intent == null || intent.getExtras() != null) {
            return;
        }
        this.k.onWbShareSuccess();
    }
}
