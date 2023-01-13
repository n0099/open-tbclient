package com.baidu.swan.webcompat.impl;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import androidx.core.view.InputDeviceCompat;
import androidx.webkit.WebViewAssetLoader;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tieba.gm4;
import com.baidu.tieba.hm4;
import com.baidu.tieba.i43;
import com.baidu.tieba.j12;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.AssetUriLoader;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
@Singleton
@Service
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b3\u00104J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0005R\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010!\u001a\u0004\u0018\u00010\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u001d\u0010$\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u001d\u0010)\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010(R\u001d\u0010-\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\u00020.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0019\u001a\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/baidu/swan/webcompat/impl/WebCompatImpl;", "Lcom/baidu/tieba/hm4;", "", "url", "getWebCompatUrl", "(Ljava/lang/String;)Ljava/lang/String;", "", "isExternalFilesUrl", "(Ljava/lang/String;)Z", "Landroid/net/Uri;", "Landroid/webkit/WebResourceResponse;", "shouldInterceptRequest", "(Landroid/net/Uri;)Landroid/webkit/WebResourceResponse;", "Target", "response", "Lkotlin/Function1;", "transform", "transformResponse", "(Landroid/webkit/WebResourceResponse;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "algorithm", "hashString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "pathForHandler", "Lcom/baidu/swan/webcompat/impl/FilePathInfo;", "externalFilePathInfo$delegate", "Lkotlin/Lazy;", "getExternalFilePathInfo", "()Lcom/baidu/swan/webcompat/impl/FilePathInfo;", "externalFilePathInfo", "Lcom/baidu/swan/webcompat/impl/ExternalStoragePathHandler;", "externalStorageFilesPathHandler$delegate", "getExternalStorageFilesPathHandler", "()Lcom/baidu/swan/webcompat/impl/ExternalStoragePathHandler;", "externalStorageFilesPathHandler", "internalFilePathInfo$delegate", "getInternalFilePathInfo", "internalFilePathInfo", "Landroidx/webkit/WebViewAssetLoader$InternalStoragePathHandler;", "internalStorageFilesPathHandler$delegate", "getInternalStorageFilesPathHandler", "()Landroidx/webkit/WebViewAssetLoader$InternalStoragePathHandler;", "internalStorageFilesPathHandler", "localAssetDomain$delegate", "getLocalAssetDomain", "()Ljava/lang/String;", "localAssetDomain", "Landroidx/webkit/WebViewAssetLoader;", "localAssetLoader$delegate", "getLocalAssetLoader", "()Landroidx/webkit/WebViewAssetLoader;", "localAssetLoader", "<init>", "()V", "Companion", "webcompat-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class WebCompatImpl implements hm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1305703541, "Lcom/baidu/swan/webcompat/impl/WebCompatImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1305703541, "Lcom/baidu/swan/webcompat/impl/WebCompatImpl;");
        }
    }

    public final FilePathInfo j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (FilePathInfo) this.b.getValue() : (FilePathInfo) invokeV.objValue;
    }

    public final gm4 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (gm4) this.e.getValue() : (gm4) invokeV.objValue;
    }

    public final FilePathInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (FilePathInfo) this.a.getValue() : (FilePathInfo) invokeV.objValue;
    }

    public final WebViewAssetLoader.InternalStoragePathHandler m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (WebViewAssetLoader.InternalStoragePathHandler) this.d.getValue() : (WebViewAssetLoader.InternalStoragePathHandler) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (String) this.c.getValue() : (String) invokeV.objValue;
    }

    public final WebViewAssetLoader o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (WebViewAssetLoader) this.f.getValue() : (WebViewAssetLoader) invokeV.objValue;
    }

    public WebCompatImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(WebCompatImpl$internalFilePathInfo$2.INSTANCE);
        this.b = LazyKt__LazyJVMKt.lazy(WebCompatImpl$externalFilePathInfo$2.INSTANCE);
        this.c = LazyKt__LazyJVMKt.lazy(WebCompatImpl$localAssetDomain$2.INSTANCE);
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<WebViewAssetLoader.InternalStoragePathHandler>(this) { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$internalStorageFilesPathHandler$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebCompatImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewAssetLoader.InternalStoragePathHandler invoke() {
                InterceptResult invokeV;
                FilePathInfo l;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    i43 K = i43.K();
                    l = this.this$0.l();
                    return new WebViewAssetLoader.InternalStoragePathHandler(K, l.c());
                }
                return (WebViewAssetLoader.InternalStoragePathHandler) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<gm4>(this) { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$externalStorageFilesPathHandler$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebCompatImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final gm4 invoke() {
                InterceptResult invokeV;
                FilePathInfo j;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (gm4) invokeV.objValue;
                }
                j = this.this$0.j();
                if (j != null) {
                    return new gm4(i43.K(), j.c());
                }
                return null;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<WebViewAssetLoader>(this) { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$localAssetLoader$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebCompatImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
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
                gm4 k;
                String q3;
                String q4;
                String q5;
                FilePathInfo j;
                String it;
                String q6;
                String q7;
                WebViewAssetLoader.InternalStoragePathHandler m3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    i43 K = i43.K();
                    WebViewAssetLoader.Builder builder = new WebViewAssetLoader.Builder();
                    n = this.this$0.n();
                    builder.setDomain(n).setHttpAllowed(true);
                    q = this.this$0.q(NetDiskFileMsg.JSON_KEY_FILES);
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
        });
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            FilePathInfo j = j();
            if (j != null) {
                String b = j.b();
                Intrinsics.checkNotNullExpressionValue(b, "it.filesUrl");
                return StringsKt__StringsJVMKt.startsWith(str, b, true);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.hm4
    public <Target> Target c(WebResourceResponse webResourceResponse, Function1<? super WebResourceResponse, ? extends Target> transform) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webResourceResponse, transform)) == null) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return transform.invoke(webResourceResponse);
        }
        return (Target) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.hm4
    public String a(final String url) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, url)) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            final WebCompatImpl$getWebCompatUrl$1 webCompatImpl$getWebCompatUrl$1 = new WebCompatImpl$getWebCompatUrl$1(this, url);
            Function0<String> function0 = new Function0<String>(this, webCompatImpl$getWebCompatUrl$1, url) { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$getWebCompatUrl$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $url;
                public final /* synthetic */ WebCompatImpl$getWebCompatUrl$1 $urlTransform$1;
                public final /* synthetic */ WebCompatImpl this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, webCompatImpl$getWebCompatUrl$1, url};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$urlTransform$1 = webCompatImpl$getWebCompatUrl$1;
                    this.$url = url;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    FilePathInfo j;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        j = this.this$0.j();
                        if (j != null) {
                            WebCompatImpl$getWebCompatUrl$1 webCompatImpl$getWebCompatUrl$12 = this.$urlTransform$1;
                            String b = j.b();
                            Intrinsics.checkNotNullExpressionValue(b, "it.filesUrl");
                            String invoke2 = webCompatImpl$getWebCompatUrl$12.invoke2(b, "external_files");
                            if (invoke2 != null) {
                                return invoke2;
                            }
                        }
                        return this.$url;
                    }
                    return (String) invokeV.objValue;
                }
            };
            String b = l().b();
            Intrinsics.checkNotNullExpressionValue(b, "internalFilePathInfo.filesUrl");
            if (StringsKt__StringsJVMKt.startsWith(url, b, true)) {
                String b2 = l().b();
                Intrinsics.checkNotNullExpressionValue(b2, "internalFilePathInfo.filesUrl");
                str = webCompatImpl$getWebCompatUrl$1.invoke2(b2, "internal_files");
            } else if (StringsKt__StringsJVMKt.startsWith(url, NetDiskFileMsg.JSON_KEY_FILES, true)) {
                str = webCompatImpl$getWebCompatUrl$1.invoke2(NetDiskFileMsg.JSON_KEY_FILES, "internal_files");
            } else if (StringsKt__StringsJVMKt.startsWith(url, "file:///android_asset/", true)) {
                str = webCompatImpl$getWebCompatUrl$1.invoke2("file:///android_asset/", AssetUriLoader.ASSET_PATH_SEGMENT);
            } else if (StringsKt__StringsJVMKt.startsWith(url, "file:///android_res/", true)) {
                str = webCompatImpl$getWebCompatUrl$1.invoke2("file:///android_res/", "android_res");
            } else if (p(url)) {
                str = function0.invoke();
            } else {
                str = url;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getWebCompatUrl: ret update = ");
            sb.append(!Intrinsics.areEqual(str, url));
            sb.append("\n > from url = ");
            sb.append(url);
            sb.append("\n > to   url = ");
            sb.append(str);
            j12.i("WebCompatImpl", sb.toString());
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hm4
    public WebResourceResponse b(Uri url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url)) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            WebResourceResponse shouldInterceptRequest = o().shouldInterceptRequest(url);
            j12.i("WebCompatImpl", "shouldInterceptRequest response=" + shouldInterceptRequest + " for url=" + url);
            return shouldInterceptRequest;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            StringBuilder sb = new StringBuilder(str);
            if (!StringsKt__StringsKt.startsWith$default((CharSequence) sb, (CharSequence) "/", false, 2, (Object) null)) {
                sb.insert(0, "/");
            }
            if (!StringsKt__StringsKt.endsWith$default((CharSequence) sb, (CharSequence) "/", false, 2, (Object) null)) {
                sb.append("/");
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(this).let …  it.toString()\n        }");
            return sb2;
        }
        return (String) invokeL.objValue;
    }
}
