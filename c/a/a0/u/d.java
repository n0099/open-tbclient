package c.a.a0.u;

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
    public static final class a implements c.a.a0.u.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.LongRef a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f1609b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f1610c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f1611d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.a0.n.a f1612e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f1613f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f1614g;

        public a(Ref.LongRef longRef, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, c.a.a0.n.a aVar, File file, Ref.BooleanRef booleanRef) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {longRef, objectRef, objectRef2, objectRef3, aVar, file, booleanRef};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = longRef;
            this.f1609b = objectRef;
            this.f1610c = objectRef2;
            this.f1611d = objectRef3;
            this.f1612e = aVar;
            this.f1613f = file;
            this.f1614g = booleanRef;
        }

        @Override // c.a.a0.u.p.a
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.f1612e.accept(new o(false, this.a.element, (String) this.f1609b.element, (String) this.f1610c.element, exc));
            }
        }

        /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r11v19, types: [T, java.lang.Exception] */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
        @Override // c.a.a0.u.p.a
        public void c(Headers headers, InputStream inputStream, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                if (headers != null && inputStream != null) {
                    this.f1609b.element = headers.d(com.baidubce.http.Headers.ETAG);
                    this.f1610c.element = headers.d(com.baidubce.http.Headers.LAST_MODIFIED);
                    if (i == 200) {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f1613f);
                        this.a.element = c.a.a0.h0.h.b(inputStream, fileOutputStream);
                        c.a.a0.h.d.a(inputStream);
                        c.a.a0.h.d.a(fileOutputStream);
                    } else if (i != 304) {
                        this.f1614g.element = false;
                        Ref.ObjectRef objectRef = this.f1611d;
                        objectRef.element = new Exception("Unsupport http code:" + i);
                    }
                    this.f1612e.accept(new o(this.f1614g.element, this.a.element, (String) this.f1609b.element, (String) this.f1610c.element, (Exception) this.f1611d.element));
                    return;
                }
                this.f1612e.accept(new o(false, this.a.element, (String) this.f1609b.element, (String) this.f1610c.element, (Exception) this.f1611d.element));
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2, types: [T, java.lang.String] */
    public void a(String url, i meta, File toFile, c.a.a0.n.a<j> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, url, meta, toFile, callback) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(meta, "meta");
            Intrinsics.checkNotNullParameter(toFile, "toFile");
            Intrinsics.checkNotNullParameter(callback, "callback");
            k a2 = g.b().a();
            Intrinsics.checkNotNullExpressionValue(a2, "HttpFactory.getInstance().getHttp()");
            c.a.a0.u.s.d dVar = new c.a.a0.u.s.d();
            dVar.k(url);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = meta.a;
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = meta.f1619b;
            if (!meta.f1620c) {
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
