package c.a.q0.b3.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b extends c.a.q0.b3.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public Tencent f16013h;

    /* renamed from: i  reason: collision with root package name */
    public int f16014i;

    /* renamed from: j  reason: collision with root package name */
    public IUiListener f16015j;
    public ShareEntity k;
    public final c.a.e.e.l.c<EmotionShareLoaderProc.EmotionShare> l;
    public c.a.e.e.l.c<c.a.e.l.d.a> m;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.e.l.c<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16016a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16016a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i2) == null) {
                super.onLoaded(emotionShare, str, i2);
                if (emotionShare != null && emotionShare.image != null && !TextUtils.isEmpty(emotionShare.path)) {
                    b bVar = this.f16016a;
                    bVar.D(emotionShare.path, bVar.f16015j);
                    return;
                }
                b bVar2 = this.f16016a;
                bVar2.w(2, bVar2.f16014i);
            }
        }

        @Override // c.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                b bVar = this.f16016a;
                bVar.w(3, bVar.f16014i);
            }
        }
    }

    /* renamed from: c.a.q0.b3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0760b extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16017a;

        /* renamed from: c.a.q0.b3.d.b$b$a */
        /* loaded from: classes3.dex */
        public class a extends BdAsyncTask<c.a.e.l.d.a, Void, Bitmap> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C0760b f16018a;

            public a(C0760b c0760b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0760b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16018a = c0760b;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Bitmap doInBackground(c.a.e.l.d.a... aVarArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVarArr)) == null) {
                    if (aVarArr.length <= 0 || aVarArr[0] == null) {
                        return null;
                    }
                    Bitmap p = aVarArr[0].p();
                    b bVar = this.f16018a.f16017a;
                    return bVar.r(p, bVar.k, true);
                }
                return (Bitmap) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                    super.onPostExecute((a) bitmap);
                    b bVar = this.f16018a.f16017a;
                    bVar.C(bVar.k, bVar.f16015j);
                }
            }
        }

        public C0760b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16017a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((C0760b) aVar, str, i2);
                if (aVar != null) {
                    a aVar2 = new a(this);
                    aVar2.setPriority(3);
                    aVar2.execute(aVar);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.q0.b3.e.b f16019a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f16020b;

        public c(b bVar, c.a.q0.b3.e.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16020b = bVar;
            this.f16019a = bVar2;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FileHelper.deleteFile(new File(c.a.q0.b3.d.a.f16006e + c.a.q0.b3.d.a.f16007f));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.q0.b3.e.b bVar = this.f16019a;
                if (bVar != null) {
                    bVar.onShare(this.f16020b.f16014i, 3);
                }
                int i2 = this.f16020b.f16014i;
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                c.a.q0.b3.e.b bVar = this.f16019a;
                if (bVar != null) {
                    bVar.onShare(this.f16020b.f16014i, 1);
                }
                b bVar2 = this.f16020b;
                bVar2.w(1, bVar2.f16014i);
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, uiError) == null) {
                c.a.q0.b3.e.b bVar = this.f16019a;
                if (bVar != null) {
                    bVar.onShare(this.f16020b.f16014i, 2);
                }
                String str = uiError != null ? uiError.errorMessage : null;
                b bVar2 = this.f16020b;
                bVar2.x(2, str, bVar2.f16014i);
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f16014i = 8;
        this.l = new a(this);
        this.m = new C0760b(this);
        this.f16013h = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    public final void B(ShareEntity shareEntity, c.a.q0.b3.e.b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, shareEntity, bVar) == null) || shareEntity == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        Iterator<ResolveInfo> it = this.f16010b.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            ResolveInfo next = it.next();
            if (TextUtils.equals("com.tencent.mobileqq", next.activityInfo.packageName)) {
                str = next.activityInfo.name;
                break;
            }
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("text/plain");
        intent2.putExtra("android.intent.extra.SUBJECT", shareEntity.getTitle());
        intent2.putExtra("android.intent.extra.TEXT", shareEntity.getContent());
        intent2.setClassName("com.tencent.mobileqq", str);
        intent2.setFlags(268435456);
        if (c.a.q0.b3.f.a.b(this.f16010b, intent2)) {
            if (bVar != null) {
                bVar.onShare(this.f16014i, 1);
                return;
            }
            return;
        }
        if (bVar != null) {
            bVar.onShare(this.f16014i, 2);
        }
        w(2, this.f16014i);
    }

    public final void C(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareEntity, iUiListener) == null) || shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", shareEntity.getTitle());
        if (shareEntity.getReadCount() >= 0) {
            if (shareEntity.getReadCount() < 10000) {
                bundle.putString("summary", this.f16010b.getString(R.string.share_qq_default_content));
            } else {
                bundle.putString("summary", StringHelper.numberUniformFormatExtra(shareEntity.getReadCount()) + this.f16010b.getString(R.string.share_qq_content));
            }
        } else {
            bundle.putString("summary", shareEntity.getContent());
        }
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        bundle.putInt("req_type", 1);
        if (shareEntity.getIsVideoThread() && !StringUtils.isNull(shareEntity.getImgUrl()) && !shareEntity.getImgUrl().startsWith("http")) {
            bundle.putString("imageLocalUrl", shareEntity.getImgUrl());
        } else {
            bundle.putString("imageUrl", shareEntity.getImgUrl());
        }
        this.f16013h.shareToQQ((Activity) this.f16010b, bundle, iUiListener);
    }

    public final void D(String str, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, iUiListener) == null) || TextUtils.isEmpty(str) || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 2);
        this.f16013h.shareToQQ((Activity) this.f16010b, bundle, iUiListener);
    }

    public final void E(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, shareEntity, iUiListener) == null) || shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", c.a.q0.b3.f.a.a(this.f16010b));
        if (!StringUtils.isNull(shareEntity.getTitle())) {
            bundle.putString("summary", shareEntity.getTitle());
        } else if (!StringUtils.isNull(shareEntity.getContent())) {
            bundle.putString("summary", shareEntity.getContent());
        } else {
            bundle.putString("summary", this.f16010b.getString(R.string.share_qq_default_content));
        }
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        if (!StringUtils.isNull(shareEntity.getImgUrl())) {
            bundle.putString("imageUrl", shareEntity.getImgUrl());
        } else {
            bundle.putString("imageUrl", "http://tb3.bdstatic.com/public/img/fcf10e29473417fa5e0d4a1e6.fcf10e29.png");
        }
        bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID, "1111264064");
        bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE, "3");
        bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH, "pages/pb/pb?tid=" + shareEntity.getTid());
        bundle.putInt("req_type", 7);
        this.f16013h.shareToQQ((Activity) this.f16010b, bundle, iUiListener);
    }

    @Override // c.a.q0.b3.e.a
    public void a(ShareEntity shareEntity, c.a.q0.b3.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, shareEntity, bVar) == null) {
            if (shareEntity != null && this.f16013h != null) {
                Context context = this.f16010b;
                if (context != null && (context instanceof Activity)) {
                    this.f16015j = new c(this, bVar);
                    if (!QqShareH5Switch.isOn() && !StringUtils.isNull(shareEntity.getTid()) && !"0".equals(shareEntity.getTid())) {
                        E(shareEntity, this.f16015j);
                        return;
                    }
                    String imgUrl = shareEntity.getImgUrl();
                    if (n(shareEntity.getLocalFile())) {
                        D(shareEntity.getLocalFile(), this.f16015j);
                        return;
                    } else if (shareEntity.getShareType() != 0 && !TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        c.a.e.e.l.d.h().k(imgUrl, 34, this.l, 0, 0, h(), new Object[0]);
                        return;
                    } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                        this.k = shareEntity;
                        if (shareEntity.getIsVideoThread()) {
                            c.a.e.e.l.d.h().k(shareEntity.getImgUrl(), 10, this.m, 0, 0, h(), new Object[0]);
                            return;
                        } else {
                            C(shareEntity, this.f16015j);
                            return;
                        }
                    } else if (m(shareEntity.getImageUri())) {
                        D(shareEntity.getImageUri().getPath(), this.f16015j);
                        return;
                    } else {
                        B(shareEntity, bVar);
                        return;
                    }
                }
                w(2, this.f16014i);
                if (bVar != null) {
                    bVar.onShare(0, 2);
                    return;
                }
                return;
            }
            w(2, this.f16014i);
            if (bVar != null) {
                bVar.onShare(0, 2);
            }
        }
    }
}
