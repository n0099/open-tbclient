package com.baidu.swan.webcompat.impl;

import android.net.Uri;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00018F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001d\u0010\t\u001a\u00020\u00018F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\u00020\u000f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/baidu/swan/webcompat/impl/FilePathInfo;", "", "filesPath$delegate", "Lkotlin/Lazy;", "getFilesPath", "()Ljava/lang/String;", "filesPath", "filesUrl$delegate", "getFilesUrl", "filesUrl", "Ljava/io/File;", "root", "Ljava/io/File;", "getRoot", "()Ljava/io/File;", "Landroid/net/Uri;", "uri$delegate", "getUri", "()Landroid/net/Uri;", "uri", "<init>", "(Ljava/io/File;)V", "webcompat-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class FilePathInfo {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final File d;

    public final String a() {
        return (String) this.c.getValue();
    }

    public final String b() {
        return (String) this.b.getValue();
    }

    public final Uri d() {
        return (Uri) this.a.getValue();
    }

    public FilePathInfo(File root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.d = root;
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<Uri>() { // from class: com.baidu.swan.webcompat.impl.FilePathInfo$uri$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Uri invoke() {
                return Uri.fromFile(FilePathInfo.this.c());
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.baidu.swan.webcompat.impl.FilePathInfo$filesUrl$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return FilePathInfo.this.d().toString();
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.baidu.swan.webcompat.impl.FilePathInfo$filesPath$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return FilePathInfo.this.d().getPath();
            }
        });
    }

    public final File c() {
        return this.d;
    }
}
