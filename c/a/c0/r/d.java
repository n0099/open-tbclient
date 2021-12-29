package c.a.c0.r;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements c.a.c0.r.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.LongRef a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f2268b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f2269c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f2270d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.k.a f2271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f2272f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f2273g;

        public a(Ref.LongRef longRef, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, c.a.c0.k.a aVar, File file, Ref.BooleanRef booleanRef) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {longRef, objectRef, objectRef2, objectRef3, aVar, file, booleanRef};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = longRef;
            this.f2268b = objectRef;
            this.f2269c = objectRef2;
            this.f2270d = objectRef3;
            this.f2271e = aVar;
            this.f2272f = file;
            this.f2273g = booleanRef;
        }

        @Override // c.a.c0.r.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                this.f2271e.accept(new o(false, this.a.element, (String) this.f2268b.element, (String) this.f2269c.element, exc));
            }
        }

        /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r11v19, types: [T, java.lang.Exception] */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
        @Override // c.a.c0.r.p.a
        public void c(Headers headers, InputStream inputStream, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i2) == null) {
                if (headers != null && inputStream != null) {
                    this.f2268b.element = headers.d("ETag");
                    this.f2269c.element = headers.d("Last-Modified");
                    if (i2 == 200) {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f2272f);
                        this.a.element = c.a.c0.d0.h.b(inputStream, fileOutputStream);
                        c.a.c0.e.d.a(inputStream);
                        c.a.c0.e.d.a(fileOutputStream);
                    } else if (i2 != 304) {
                        this.f2273g.element = false;
                        Ref.ObjectRef objectRef = this.f2270d;
                        objectRef.element = new Exception("Unsupport http code:" + i2);
                    }
                    this.f2271e.accept(new o(this.f2273g.element, this.a.element, (String) this.f2268b.element, (String) this.f2269c.element, (Exception) this.f2270d.element));
                    return;
                }
                this.f2271e.accept(new o(false, this.a.element, (String) this.f2268b.element, (String) this.f2269c.element, (Exception) this.f2270d.element));
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2, types: [T, java.lang.String] */
    public void a(String url, i meta, File toFile, c.a.c0.k.a<j> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, url, meta, toFile, callback) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(meta, "meta");
            Intrinsics.checkNotNullParameter(toFile, "toFile");
            Intrinsics.checkNotNullParameter(callback, "callback");
            k a2 = g.b().a();
            Intrinsics.checkNotNullExpressionValue(a2, "HttpFactory.getInstance().getHttp()");
            c.a.c0.r.s.d dVar = new c.a.c0.r.s.d();
            dVar.k(url);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = meta.a;
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = meta.f2278b;
            if (!meta.f2279c) {
                if (!TextUtils.isEmpty((String) objectRef.element)) {
                    dVar.a("If-None-Match", (String) objectRef.element);
                }
                if (!TextUtils.isEmpty((String) objectRef2.element)) {
                    dVar.a("If-Modified-Since", (String) objectRef2.element);
                }
            }
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = 0L;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = null;
            a2.b(dVar, new a(longRef, objectRef, objectRef2, objectRef3, callback, toFile, booleanRef));
        }
    }
}
