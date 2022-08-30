package com.baidu.swan.webcompat.impl;

import androidx.webkit.WebViewAssetLoader;
import com.baidu.tieba.vi4;
import com.baidu.tieba.z03;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.AssetUriLoader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/webkit/WebViewAssetLoader;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class WebCompatImpl$localAssetLoader$2 extends Lambda implements Function0<WebViewAssetLoader> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ WebCompatImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebCompatImpl$localAssetLoader$2(WebCompatImpl webCompatImpl) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webCompatImpl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = webCompatImpl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WebViewAssetLoader invoke() {
        InterceptResult invokeV;
        String n;
        String q;
        WebViewAssetLoader.InternalStoragePathHandler m;
        String q2;
        WebViewAssetLoader.InternalStoragePathHandler m2;
        FilePathInfo l;
        vi4 k;
        String q3;
        String q4;
        String q5;
        FilePathInfo j;
        String it;
        String q6;
        String q7;
        WebViewAssetLoader.InternalStoragePathHandler m3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            z03 K = z03.K();
            WebViewAssetLoader.Builder builder = new WebViewAssetLoader.Builder();
            n = this.this$0.n();
            builder.setDomain(n).setHttpAllowed(true);
            q = this.this$0.q("files");
            m = this.this$0.m();
            builder.addPathHandler(q, m);
            q2 = this.this$0.q("internal_files");
            m2 = this.this$0.m();
            builder.addPathHandler(q2, m2);
            l = this.this$0.l();
            String it2 = l.a();
            if (it2 != null) {
                WebCompatImpl webCompatImpl = this.this$0;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                q7 = webCompatImpl.q(it2);
                m3 = this.this$0.m();
                builder.addPathHandler(q7, m3);
            }
            k = this.this$0.k();
            if (k != null) {
                q5 = this.this$0.q("external_files");
                builder.addPathHandler(q5, k);
                j = this.this$0.j();
                if (j != null && (it = j.a()) != null) {
                    WebCompatImpl webCompatImpl2 = this.this$0;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    q6 = webCompatImpl2.q(it);
                    builder.addPathHandler(q6, k);
                }
            }
            q3 = this.this$0.q(AssetUriLoader.ASSET_PATH_SEGMENT);
            builder.addPathHandler(q3, new WebViewAssetLoader.AssetsPathHandler(K));
            q4 = this.this$0.q("android_res");
            builder.addPathHandler(q4, new WebViewAssetLoader.ResourcesPathHandler(K));
            WebViewAssetLoader build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "WebViewAssetLoader.Build…(swan))\n        }.build()");
            return build;
        }
        return (WebViewAssetLoader) invokeV.objValue;
    }
}
