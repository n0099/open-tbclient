package b.a.r0.d3.d;

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
/* loaded from: classes4.dex */
public class b extends b.a.r0.d3.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public Tencent f15707h;

    /* renamed from: i  reason: collision with root package name */
    public int f15708i;
    public IUiListener j;
    public ShareEntity k;
    public final b.a.e.e.l.c<EmotionShareLoaderProc.EmotionShare> l;
    public b.a.e.e.l.c<b.a.e.l.d.a> m;

    /* loaded from: classes4.dex */
    public class a extends b.a.e.e.l.c<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f15709a;

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
            this.f15709a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i2) == null) {
                super.onLoaded(emotionShare, str, i2);
                if (emotionShare != null && emotionShare.image != null && !TextUtils.isEmpty(emotionShare.path)) {
                    b bVar = this.f15709a;
                    bVar.D(emotionShare.path, bVar.j);
                    return;
                }
                b bVar2 = this.f15709a;
                bVar2.w(2, bVar2.f15708i);
            }
        }

        @Override // b.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                b bVar = this.f15709a;
                bVar.w(3, bVar.f15708i);
            }
        }
    }

    /* renamed from: b.a.r0.d3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0797b extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f15710a;

        /* renamed from: b.a.r0.d3.d.b$b$a */
        /* loaded from: classes4.dex */
        public class a extends BdAsyncTask<b.a.e.l.d.a, Void, Bitmap> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C0797b f15711a;

            public a(C0797b c0797b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0797b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15711a = c0797b;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Bitmap doInBackground(b.a.e.l.d.a... aVarArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVarArr)) == null) {
                    if (aVarArr.length <= 0 || aVarArr[0] == null) {
                        return null;
                    }
                    Bitmap p = aVarArr[0].p();
                    b bVar = this.f15711a.f15710a;
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
                    b bVar = this.f15711a.f15710a;
                    bVar.C(bVar.k, bVar.j);
                }
            }
        }

        public C0797b(b bVar) {
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
            this.f15710a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((C0797b) aVar, str, i2);
                if (aVar != null) {
                    a aVar2 = new a(this);
                    aVar2.setPriority(3);
                    aVar2.execute(aVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.r0.d3.e.b f15712a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f15713b;

        public c(b bVar, b.a.r0.d3.e.b bVar2) {
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
            this.f15713b = bVar;
            this.f15712a = bVar2;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FileHelper.deleteFile(new File(b.a.r0.d3.d.a.f15700e + b.a.r0.d3.d.a.f15701f));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.r0.d3.e.b bVar = this.f15712a;
                if (bVar != null) {
                    bVar.onShare(this.f15713b.f15708i, 3);
                }
                int i2 = this.f15713b.f15708i;
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                b.a.r0.d3.e.b bVar = this.f15712a;
                if (bVar != null) {
                    bVar.onShare(this.f15713b.f15708i, 1);
                }
                b bVar2 = this.f15713b;
                bVar2.w(1, bVar2.f15708i);
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, uiError) == null) {
                b.a.r0.d3.e.b bVar = this.f15712a;
                if (bVar != null) {
                    bVar.onShare(this.f15713b.f15708i, 2);
                }
                String str = uiError != null ? uiError.errorMessage : null;
                b bVar2 = this.f15713b;
                bVar2.x(2, str, bVar2.f15708i);
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
        this.f15708i = 8;
        this.l = new a(this);
        this.m = new C0797b(this);
        this.f15707h = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    public final void B(ShareEntity shareEntity, b.a.r0.d3.e.b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, shareEntity, bVar) == null) || shareEntity == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        Iterator<ResolveInfo> it = this.f15704b.getPackageManager().queryIntentActivities(intent, 0).iterator();
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
        if (b.a.r0.d3.f.a.startActivity(this.f15704b, intent2)) {
            if (bVar != null) {
                bVar.onShare(this.f15708i, 1);
                return;
            }
            return;
        }
        if (bVar != null) {
            bVar.onShare(this.f15708i, 2);
        }
        w(2, this.f15708i);
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
                bundle.putString("summary", this.f15704b.getString(R.string.share_qq_default_content));
            } else {
                bundle.putString("summary", StringHelper.numberUniformFormatExtra(shareEntity.getReadCount()) + this.f15704b.getString(R.string.share_qq_content));
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
        this.f15707h.shareToQQ((Activity) this.f15704b, bundle, iUiListener);
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
        this.f15707h.shareToQQ((Activity) this.f15704b, bundle, iUiListener);
    }

    public final void E(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, shareEntity, iUiListener) == null) || shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", b.a.r0.d3.f.a.a(this.f15704b));
        if (!StringUtils.isNull(shareEntity.getTitle())) {
            bundle.putString("summary", shareEntity.getTitle());
        } else if (!StringUtils.isNull(shareEntity.getContent())) {
            bundle.putString("summary", shareEntity.getContent());
        } else {
            bundle.putString("summary", this.f15704b.getString(R.string.share_qq_default_content));
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
        this.f15707h.shareToQQ((Activity) this.f15704b, bundle, iUiListener);
    }

    @Override // b.a.r0.d3.e.a
    public void a(ShareEntity shareEntity, b.a.r0.d3.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, shareEntity, bVar) == null) {
            if (shareEntity != null && this.f15707h != null) {
                Context context = this.f15704b;
                if (context != null && (context instanceof Activity)) {
                    this.j = new c(this, bVar);
                    if (!QqShareH5Switch.isOn() && !StringUtils.isNull(shareEntity.getTid()) && !"0".equals(shareEntity.getTid())) {
                        E(shareEntity, this.j);
                        return;
                    }
                    String imgUrl = shareEntity.getImgUrl();
                    if (n(shareEntity.getLocalFile())) {
                        D(shareEntity.getLocalFile(), this.j);
                        return;
                    } else if (shareEntity.getShareType() != 0 && !TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        b.a.e.e.l.d.h().k(imgUrl, 34, this.l, 0, 0, h(), new Object[0]);
                        return;
                    } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                        this.k = shareEntity;
                        if (shareEntity.getIsVideoThread()) {
                            b.a.e.e.l.d.h().k(shareEntity.getImgUrl(), 10, this.m, 0, 0, h(), new Object[0]);
                            return;
                        } else {
                            C(shareEntity, this.j);
                            return;
                        }
                    } else if (m(shareEntity.getImageUri())) {
                        D(shareEntity.getImageUri().getPath(), this.j);
                        return;
                    } else {
                        B(shareEntity, bVar);
                        return;
                    }
                }
                w(2, this.f15708i);
                if (bVar != null) {
                    bVar.onShare(0, 2);
                    return;
                }
                return;
            }
            w(2, this.f15708i);
            if (bVar != null) {
                bVar.onShare(0, 2);
            }
        }
    }
}
