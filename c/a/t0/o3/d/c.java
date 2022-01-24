package c.a.t0.o3.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.t0.o3.d.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IUiListener n;
    public final c.a.d.f.l.c<EmotionShareLoaderProc.EmotionShare> o;

    /* loaded from: classes8.dex */
    public class a extends c.a.d.f.l.c<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i2) == null) {
                super.onLoaded(emotionShare, str, i2);
                if (emotionShare == null || emotionShare.image == null || TextUtils.isEmpty(emotionShare.path)) {
                    this.a.w(2, 4);
                }
                this.a.I(emotionShare.path);
            }
        }

        @Override // c.a.d.f.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                this.a.w(3, 4);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
        this.o = new a(this);
        this.f20331i = 4;
    }

    public final void G(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, shareEntity, iUiListener) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("req_type", 7);
            bundle.putString("title", c.a.t0.o3.f.a.a(this.f20327b));
            if (!StringUtils.isNull(shareEntity.getTitle())) {
                bundle.putString("summary", shareEntity.getTitle());
            } else if (!StringUtils.isNull(shareEntity.getContent())) {
                bundle.putString("summary", shareEntity.getContent());
            } else {
                bundle.putString("summary", this.f20327b.getString(R.string.share_qq_default_content));
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            ArrayList<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(shareEntity.getImgUrl())) {
                arrayList.add(shareEntity.getImgUrl());
            } else {
                arrayList.add("http://tb3.bdstatic.com/public/img/fcf10e29473417fa5e0d4a1e6.fcf10e29.png");
            }
            bundle.putStringArrayList("imageUrl", arrayList);
            bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID, "1111264064");
            bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE, "3");
            bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH, "pages/pb/pb?tid=" + shareEntity.getTid());
            if (iUiListener != null) {
                this.f20330h.shareToQzone((Activity) this.f20327b, bundle, iUiListener);
            }
        }
    }

    public final void H(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareEntity) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("req_type", 1);
            bundle.putString("title", shareEntity.getTitle());
            bundle.putString("summary", shareEntity.getContent());
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            ArrayList<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(shareEntity.getImgUrl())) {
                arrayList.add(shareEntity.getImgUrl());
            }
            bundle.putStringArrayList("imageUrl", arrayList);
            IUiListener iUiListener = this.n;
            if (iUiListener != null) {
                this.f20330h.shareToQzone((Activity) this.f20327b, bundle, iUiListener);
            }
        }
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 1);
            IUiListener iUiListener = this.n;
            if (iUiListener != null) {
                this.f20330h.shareToQQ((Activity) this.f20327b, bundle, iUiListener);
            }
        }
    }

    public final void J(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareEntity) == null) {
            if (n(shareEntity.getLocalFile())) {
                I(shareEntity.getLocalFile());
            } else if (m(shareEntity.getImageUri())) {
                I(shareEntity.getImageUri().getPath());
            } else {
                c.a.d.f.l.d.h().k(shareEntity.getImgUrl(), 34, this.o, 0, 0, h(), new Object[0]);
            }
        }
    }

    @Override // c.a.t0.o3.d.b, c.a.t0.o3.e.a
    public void a(ShareEntity shareEntity, c.a.t0.o3.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, shareEntity, bVar) == null) {
            if (shareEntity != null && this.f20330h != null) {
                Context context = this.f20327b;
                if (context != null && (context instanceof Activity)) {
                    this.n = new b.c(this, bVar);
                    if (!QqShareH5Switch.isOn() && !StringUtils.isNull(shareEntity.getTid()) && !"0".equals(shareEntity.getTid())) {
                        G(shareEntity, this.n);
                        return;
                    } else if (shareEntity.getShareType() != 0) {
                        J(shareEntity);
                        return;
                    } else {
                        H(shareEntity);
                        return;
                    }
                }
                w(2, 4);
                if (bVar != null) {
                    bVar.onShare(0, 2);
                    return;
                }
                return;
            }
            w(2, 4);
            if (bVar != null) {
                bVar.onShare(0, 2);
            }
        }
    }
}
