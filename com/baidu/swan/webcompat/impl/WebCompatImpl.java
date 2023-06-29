package com.baidu.swan.webcompat.impl;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import androidx.webkit.WebViewAssetLoader;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tieba.au4;
import com.baidu.tieba.bc3;
import com.baidu.tieba.c92;
import com.baidu.tieba.zt4;
import com.bumptech.glide.load.model.AssetUriLoader;
import java.io.File;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b3\u00104J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0005R\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010!\u001a\u0004\u0018\u00010\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u001d\u0010$\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u001d\u0010)\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010(R\u001d\u0010-\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\u00020.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0019\u001a\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/baidu/swan/webcompat/impl/WebCompatImpl;", "Lcom/baidu/tieba/au4;", "", "url", "getWebCompatUrl", "(Ljava/lang/String;)Ljava/lang/String;", "", "isExternalFilesUrl", "(Ljava/lang/String;)Z", "Landroid/net/Uri;", "Landroid/webkit/WebResourceResponse;", "shouldInterceptRequest", "(Landroid/net/Uri;)Landroid/webkit/WebResourceResponse;", "Target", "response", "Lkotlin/Function1;", "transform", "transformResponse", "(Landroid/webkit/WebResourceResponse;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "algorithm", "hashString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "pathForHandler", "Lcom/baidu/swan/webcompat/impl/FilePathInfo;", "externalFilePathInfo$delegate", "Lkotlin/Lazy;", "getExternalFilePathInfo", "()Lcom/baidu/swan/webcompat/impl/FilePathInfo;", "externalFilePathInfo", "Lcom/baidu/swan/webcompat/impl/ExternalStoragePathHandler;", "externalStorageFilesPathHandler$delegate", "getExternalStorageFilesPathHandler", "()Lcom/baidu/swan/webcompat/impl/ExternalStoragePathHandler;", "externalStorageFilesPathHandler", "internalFilePathInfo$delegate", "getInternalFilePathInfo", "internalFilePathInfo", "Landroidx/webkit/WebViewAssetLoader$InternalStoragePathHandler;", "internalStorageFilesPathHandler$delegate", "getInternalStorageFilesPathHandler", "()Landroidx/webkit/WebViewAssetLoader$InternalStoragePathHandler;", "internalStorageFilesPathHandler", "localAssetDomain$delegate", "getLocalAssetDomain", "()Ljava/lang/String;", "localAssetDomain", "Landroidx/webkit/WebViewAssetLoader;", "localAssetLoader$delegate", "getLocalAssetLoader", "()Landroidx/webkit/WebViewAssetLoader;", "localAssetLoader", "<init>", "()V", "Companion", "webcompat-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class WebCompatImpl implements au4 {
    public final Lazy a = LazyKt__LazyJVMKt.lazy(new Function0<FilePathInfo>() { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$internalFilePathInfo$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FilePathInfo invoke() {
            bc3 K = bc3.K();
            Intrinsics.checkNotNullExpressionValue(K, "Swan.get()");
            File filesDir = K.getFilesDir();
            Intrinsics.checkNotNullExpressionValue(filesDir, "Swan.get().filesDir");
            return new FilePathInfo(filesDir);
        }
    });
    public final Lazy b = LazyKt__LazyJVMKt.lazy(new Function0<FilePathInfo>() { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$externalFilePathInfo$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FilePathInfo invoke() {
            File it = bc3.K().getExternalFilesDir(null);
            if (it == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            return new FilePathInfo(it);
        }
    });
    public final Lazy c = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$localAssetDomain$2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            StringBuilder sb = new StringBuilder();
            bc3 K = bc3.K();
            Intrinsics.checkNotNullExpressionValue(K, "Swan.get()");
            sb.append(K.getPackageName());
            sb.append(".swanhost.smartapps.cn");
            return sb.toString();
        }
    });
    public final Lazy d = LazyKt__LazyJVMKt.lazy(new Function0<WebViewAssetLoader.InternalStoragePathHandler>() { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$internalStorageFilesPathHandler$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WebViewAssetLoader.InternalStoragePathHandler invoke() {
            FilePathInfo l;
            bc3 K = bc3.K();
            l = WebCompatImpl.this.l();
            return new WebViewAssetLoader.InternalStoragePathHandler(K, l.c());
        }
    });
    public final Lazy e = LazyKt__LazyJVMKt.lazy(new Function0<zt4>() { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$externalStorageFilesPathHandler$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final zt4 invoke() {
            FilePathInfo j;
            j = WebCompatImpl.this.j();
            if (j != null) {
                return new zt4(bc3.K(), j.c());
            }
            return null;
        }
    });
    public final Lazy f = LazyKt__LazyJVMKt.lazy(new Function0<WebViewAssetLoader>() { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$localAssetLoader$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WebViewAssetLoader invoke() {
            String n;
            String q;
            WebViewAssetLoader.InternalStoragePathHandler m;
            String q2;
            WebViewAssetLoader.InternalStoragePathHandler m2;
            FilePathInfo l;
            zt4 k;
            String q3;
            String q4;
            String q5;
            FilePathInfo j;
            String it;
            String q6;
            String q7;
            WebViewAssetLoader.InternalStoragePathHandler m3;
            bc3 K = bc3.K();
            WebViewAssetLoader.Builder builder = new WebViewAssetLoader.Builder();
            n = WebCompatImpl.this.n();
            builder.setDomain(n).setHttpAllowed(true);
            q = WebCompatImpl.this.q(NetDiskFileMsg.JSON_KEY_FILES);
            m = WebCompatImpl.this.m();
            builder.addPathHandler(q, m);
            q2 = WebCompatImpl.this.q("internal_files");
            m2 = WebCompatImpl.this.m();
            builder.addPathHandler(q2, m2);
            l = WebCompatImpl.this.l();
            String it2 = l.a();
            if (it2 != null) {
                WebCompatImpl webCompatImpl = WebCompatImpl.this;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                q7 = webCompatImpl.q(it2);
                m3 = WebCompatImpl.this.m();
                builder.addPathHandler(q7, m3);
            }
            k = WebCompatImpl.this.k();
            if (k != null) {
                q5 = WebCompatImpl.this.q("external_files");
                builder.addPathHandler(q5, k);
                j = WebCompatImpl.this.j();
                if (j != null && (it = j.a()) != null) {
                    WebCompatImpl webCompatImpl2 = WebCompatImpl.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    q6 = webCompatImpl2.q(it);
                    builder.addPathHandler(q6, k);
                }
            }
            q3 = WebCompatImpl.this.q(AssetUriLoader.ASSET_PATH_SEGMENT);
            builder.addPathHandler(q3, new WebViewAssetLoader.AssetsPathHandler(K));
            q4 = WebCompatImpl.this.q("android_res");
            builder.addPathHandler(q4, new WebViewAssetLoader.ResourcesPathHandler(K));
            WebViewAssetLoader build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "WebViewAssetLoader.Build…(swan))\n        }.build()");
            return build;
        }
    });

    public final FilePathInfo j() {
        return (FilePathInfo) this.b.getValue();
    }

    public final zt4 k() {
        return (zt4) this.e.getValue();
    }

    public final FilePathInfo l() {
        return (FilePathInfo) this.a.getValue();
    }

    public final WebViewAssetLoader.InternalStoragePathHandler m() {
        return (WebViewAssetLoader.InternalStoragePathHandler) this.d.getValue();
    }

    public final String n() {
        return (String) this.c.getValue();
    }

    public final WebViewAssetLoader o() {
        return (WebViewAssetLoader) this.f.getValue();
    }

    @Override // com.baidu.tieba.au4
    public WebResourceResponse b(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        WebResourceResponse shouldInterceptRequest = o().shouldInterceptRequest(url);
        c92.i("WebCompatImpl", "shouldInterceptRequest response=" + shouldInterceptRequest + " for url=" + url);
        return shouldInterceptRequest;
    }

    public final boolean p(String str) {
        FilePathInfo j = j();
        if (j != null) {
            String b = j.b();
            Intrinsics.checkNotNullExpressionValue(b, "it.filesUrl");
            return StringsKt__StringsJVMKt.startsWith(str, b, true);
        }
        return false;
    }

    public final String q(String str) {
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

    @Override // com.baidu.tieba.au4
    public <Target> Target c(WebResourceResponse webResourceResponse, Function1<? super WebResourceResponse, ? extends Target> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        return transform.invoke(webResourceResponse);
    }

    @Override // com.baidu.tieba.au4
    public String a(final String url) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        final WebCompatImpl$getWebCompatUrl$1 webCompatImpl$getWebCompatUrl$1 = new WebCompatImpl$getWebCompatUrl$1(this, url);
        Function0<String> function0 = new Function0<String>() { // from class: com.baidu.swan.webcompat.impl.WebCompatImpl$getWebCompatUrl$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                FilePathInfo j;
                j = WebCompatImpl.this.j();
                if (j != null) {
                    WebCompatImpl$getWebCompatUrl$1 webCompatImpl$getWebCompatUrl$12 = webCompatImpl$getWebCompatUrl$1;
                    String b = j.b();
                    Intrinsics.checkNotNullExpressionValue(b, "it.filesUrl");
                    String invoke2 = webCompatImpl$getWebCompatUrl$12.invoke2(b, "external_files");
                    if (invoke2 != null) {
                        return invoke2;
                    }
                }
                return url;
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
        c92.i("WebCompatImpl", sb.toString());
        return str;
    }
}
