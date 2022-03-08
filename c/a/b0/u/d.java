package c.a.b0.u;

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
    public static final class a implements c.a.b0.u.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.LongRef a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f1994b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f1995c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f1996d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.n.a f1997e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f1998f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f1999g;

        public a(Ref.LongRef longRef, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, c.a.b0.n.a aVar, File file, Ref.BooleanRef booleanRef) {
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
            this.f1994b = objectRef;
            this.f1995c = objectRef2;
            this.f1996d = objectRef3;
            this.f1997e = aVar;
            this.f1998f = file;
            this.f1999g = booleanRef;
        }

        @Override // c.a.b0.u.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                this.f1997e.accept(new o(false, this.a.element, (String) this.f1994b.element, (String) this.f1995c.element, exc));
            }
        }

        /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r11v19, types: [T, java.lang.Exception] */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
        @Override // c.a.b0.u.p.a
        public void c(Headers headers, InputStream inputStream, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i2) == null) {
                if (headers != null && inputStream != null) {
                    this.f1994b.element = headers.d("ETag");
                    this.f1995c.element = headers.d("Last-Modified");
                    if (i2 == 200) {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f1998f);
                        this.a.element = c.a.b0.h0.h.b(inputStream, fileOutputStream);
                        c.a.b0.h.d.a(inputStream);
                        c.a.b0.h.d.a(fileOutputStream);
                    } else if (i2 != 304) {
                        this.f1999g.element = false;
                        Ref.ObjectRef objectRef = this.f1996d;
                        objectRef.element = new Exception("Unsupport http code:" + i2);
                    }
                    this.f1997e.accept(new o(this.f1999g.element, this.a.element, (String) this.f1994b.element, (String) this.f1995c.element, (Exception) this.f1996d.element));
                    return;
                }
                this.f1997e.accept(new o(false, this.a.element, (String) this.f1994b.element, (String) this.f1995c.element, (Exception) this.f1996d.element));
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
    public void a(String url, i meta, File toFile, c.a.b0.n.a<j> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, url, meta, toFile, callback) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(meta, "meta");
            Intrinsics.checkNotNullParameter(toFile, "toFile");
            Intrinsics.checkNotNullParameter(callback, "callback");
            k a2 = g.b().a();
            Intrinsics.checkNotNullExpressionValue(a2, "HttpFactory.getInstance().getHttp()");
            c.a.b0.u.s.d dVar = new c.a.b0.u.s.d();
            dVar.k(url);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = meta.a;
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = meta.f2004b;
            if (!meta.f2005c) {
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
