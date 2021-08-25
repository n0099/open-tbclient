package com.baidu.mobads.cid.cesium.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.cid.cesium.a.e;
import com.baidu.mobads.cid.cesium.b.a;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.cid.cesium.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends com.baidu.mobads.cid.cesium.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Context f42669d;

    /* renamed from: e  reason: collision with root package name */
    public f f42670e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1677a f42671f;

    /* loaded from: classes5.dex */
    public static final class a implements Comparable<a> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f42672a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final int f42673b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1933702340, "Lcom/baidu/mobads/cid/cesium/b/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1933702340, "Lcom/baidu/mobads/cid/cesium/b/d$a;");
                    return;
                }
            }
            f42672a = new String[]{"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
        }

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f42673b = i2;
        }

        public static a a(byte b2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b2), Boolean.valueOf(z)})) == null) {
                int i2 = b2 & 255;
                return a(z ? i2 >> 4 : i2 & 15);
            }
            return (a) invokeCommon.objValue;
        }

        public static a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                if (i2 < 0 || i2 >= 16) {
                    throw new IllegalArgumentException("invalid idx " + i2);
                }
                return new a(i2);
            }
            return (a) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? this.f42673b - aVar.f42673b : invokeL.intValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f42672a[this.f42673b] : (String) invokeV.objValue;
        }

        public byte b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (byte) this.f42673b : invokeV.byteValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return obj != null && a.class == obj.getClass() && this.f42673b == ((a) obj).f42673b;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42673b : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42674a;

        /* renamed from: b  reason: collision with root package name */
        public int f42675b;

        /* renamed from: c  reason: collision with root package name */
        public a[] f42676c;

        /* renamed from: d  reason: collision with root package name */
        public int f42677d;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42674a = dVar;
            this.f42675b = 33;
            this.f42676c = new a[33];
        }

        private void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
                a[] aVarArr = this.f42676c;
                if (i2 - aVarArr.length > 0) {
                    int length = aVarArr.length;
                    int i3 = length + (length >> 1);
                    if (i3 - i2 >= 0) {
                        i2 = i3;
                    }
                    this.f42676c = (a[]) Arrays.copyOf(this.f42676c, i2);
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42677d : invokeV.intValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 < this.f42677d) {
                    return this.f42676c[i2];
                }
                throw new IndexOutOfBoundsException("idx " + i2 + " size " + this.f42677d);
            }
            return (a) invokeI.objValue;
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                b(this.f42677d + 1);
                a[] aVarArr = this.f42676c;
                int i2 = this.f42677d;
                this.f42677d = i2 + 1;
                aVarArr[i2] = aVar;
            }
        }

        public byte[] b() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i3 = 0;
                while (true) {
                    i2 = this.f42677d;
                    if (i3 >= i2 / 2) {
                        break;
                    }
                    int i4 = i3 * 2;
                    byteArrayOutputStream.write((byte) (((a(i4 + 1).b() & 255) << 4) | (a(i4).b() & 255)));
                    i3++;
                }
                if (i2 % 2 != 0) {
                    byteArrayOutputStream.write((byte) (a(i2 - 1).b() & 255));
                }
                return byteArrayOutputStream.toByteArray();
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<a> f42678a;

        /* loaded from: classes5.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f42680a;

            /* renamed from: b  reason: collision with root package name */
            public a f42681b;

            public a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42681b = aVar;
            }

            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f42680a++;
                }
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42678a = new ArrayList();
        }

        public List<a> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(this.f42678a);
                Collections.sort(arrayList, new Comparator<a>(this) { // from class: com.baidu.mobads.cid.cesium.b.d.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f42679a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f42679a = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(a aVar, a aVar2) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, aVar, aVar2)) == null) ? aVar.f42680a - aVar2.f42680a : invokeLL.intValue;
                    }
                });
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f42678a.add(new a(aVar));
            }
        }
    }

    /* renamed from: com.baidu.mobads.cid.cesium.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1676d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public byte[] f42682a;

        /* renamed from: b  reason: collision with root package name */
        public byte f42683b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f42684c;

        public C1676d(byte[] bArr, byte b2, byte[] bArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Byte.valueOf(b2), bArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42682a = bArr;
            this.f42683b = b2;
            this.f42684c = bArr2;
        }

        public g.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return com.baidu.mobads.cid.cesium.g.a(com.baidu.mobads.cid.cesium.d.b.a(this.f42682a, "", true), new String(new byte[]{this.f42683b}, "UTF-8"), this.f42684c != null ? new String(this.f42684c, "UTF-8") : null);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (g.a) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f42685a;

        /* renamed from: b  reason: collision with root package name */
        public int f42686b;

        /* renamed from: c  reason: collision with root package name */
        public int f42687c;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42687c = 16;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Method f42688a;

        /* renamed from: b  reason: collision with root package name */
        public Method f42689b;

        /* renamed from: c  reason: collision with root package name */
        public Method f42690c;

        /* renamed from: d  reason: collision with root package name */
        public Method f42691d;

        /* renamed from: e  reason: collision with root package name */
        public Method f42692e;

        public f() {
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

        public int a(Context context, Uri uri, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                try {
                    return ((Integer) this.f42688a.invoke(context, uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))).intValue();
                } catch (Exception e2) {
                    throw new e.a(e2);
                }
            }
            return invokeCommon.intValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.f42688a = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.d()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    this.f42689b = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.e()), new Class[]{String.class, Uri.class, Integer.TYPE});
                    this.f42690c = com.baidu.mobads.cid.cesium.a.e.a(ContentResolver.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.f()), new Class[]{Uri.class, Integer.TYPE});
                    this.f42691d = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.g()), new Class[]{Uri.class, Integer.TYPE});
                    this.f42692e = com.baidu.mobads.cid.cesium.a.e.a(ContentResolver.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.h()), new Class[]{Uri.class, Integer.TYPE});
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42693a;

        /* renamed from: b  reason: collision with root package name */
        public int f42694b;

        /* renamed from: c  reason: collision with root package name */
        public String f42695c;

        /* renamed from: d  reason: collision with root package name */
        public long f42696d;

        /* renamed from: e  reason: collision with root package name */
        public long f42697e;

        /* renamed from: f  reason: collision with root package name */
        public g.a f42698f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(d dVar, String str) {
            super(dVar.f42671f, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a.C1677a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42693a = dVar;
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f42695c = jSONObject.getString("pkg");
                this.f42696d = jSONObject.getLong("last_fe_ts");
                this.f42698f = com.baidu.mobads.cid.cesium.g.a(jSONObject.getString("info"));
                this.f42697e = jSONObject.getLong("tar_pkg_lst_up_ts");
                this.f42694b = jSONObject.getInt("d_form_ver");
            }
        }

        public boolean a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                if (this.f42696d != j2) {
                    this.f42696d = j2;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean a(g.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                if (aVar.equals(this.f42698f)) {
                    return false;
                }
                this.f42698f = aVar;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str.equals(this.f42695c)) {
                    return false;
                }
                this.f42695c = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f42695c);
                jSONObject.put("last_fe_ts", this.f42696d);
                jSONObject.put("info", this.f42698f.b());
                jSONObject.put("tar_pkg_lst_up_ts", this.f42697e);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public boolean b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                if (this.f42697e != j2) {
                    this.f42697e = j2;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f42695c : (String) invokeV.objValue;
        }

        public g.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f42698f : (g.a) invokeV.objValue;
        }

        public long e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f42697e : invokeV.longValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d() {
        super("upc", 9000000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f fVar = new f();
        this.f42670e = fVar;
        fVar.a();
    }

    private a a(String str, int i2, List<c.a> list, int i3, e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{str, Integer.valueOf(i2), list, Integer.valueOf(i3), eVar})) == null) {
            for (c.a aVar : list) {
                if (a(str, i2, aVar.f42681b, i3, eVar)) {
                    aVar.a();
                    return aVar.f42681b;
                }
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            return str + ".cesium";
        }
        return (String) invokeL.objValue;
    }

    private String a(String str, int i2, a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, i2, aVar)) == null) ? String.format("content://%s/dat/v1/i%d/%s", a(str), Integer.valueOf(i2), aVar.a()) : (String) invokeLIL.objValue;
    }

    private String a(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, aVar)) == null) ? String.format("content://%s/dic/v1/%s", a(str), aVar.a()) : (String) invokeLL.objValue;
    }

    private boolean a(String str, int i2, a aVar, int i3, e eVar) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, Integer.valueOf(i2), aVar, Integer.valueOf(i3), eVar})) == null) {
            Uri parse = Uri.parse(a(str, i2, aVar));
            int i5 = 0;
            while (true) {
                if (i5 >= 2) {
                    i4 = -1;
                    break;
                }
                if (eVar != null) {
                    try {
                        eVar.f42685a++;
                    } catch (Throwable unused) {
                        try {
                            Thread.sleep(5L);
                        } catch (Exception unused2) {
                        }
                        i5++;
                    }
                }
                i4 = this.f42670e.a(this.f42669d, parse, 0, i3, 1);
                break;
            }
            if (i4 == 0) {
                return true;
            }
            if (eVar != null) {
                eVar.f42686b++;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean a(String str, a aVar, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, this, str, aVar, i2)) == null) {
            Uri parse = Uri.parse(a(str, aVar));
            int i4 = 0;
            while (true) {
                if (i4 >= 2) {
                    i3 = -1;
                    break;
                }
                try {
                    i3 = this.f42670e.a(this.f42669d, parse, 0, i2, 1);
                    break;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i4++;
                }
            }
            return i3 == 0;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public a.e a(String str, a.d dVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        g gVar;
        Byte b2;
        boolean z;
        Byte b3;
        byte[] bArr;
        g.a a2;
        b bVar;
        g.a d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, dVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return a.e.b();
            }
            boolean z2 = false;
            try {
                packageInfo = this.f42669d.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.e.b();
            }
            if (dVar.f42647a) {
                g gVar2 = new g(this, str);
                gVar2.a();
                if (str.equals(gVar2.c()) && packageInfo.lastUpdateTime == gVar2.e() && (d2 = gVar2.d()) != null) {
                    return a.e.a(d2);
                }
                gVar = gVar2;
            } else {
                gVar = null;
            }
            e eVar = new e();
            b bVar2 = new b(this);
            c cVar = new c();
            c cVar2 = new c();
            int i2 = packageInfo.applicationInfo.uid;
            for (int i3 = 0; i3 < 16; i3++) {
                a a3 = a.a(i3);
                if (a(str, a3, i2)) {
                    cVar.a(a3);
                } else {
                    cVar2.a(a3);
                }
            }
            int i4 = 0;
            while (i4 < 32) {
                int i5 = i4;
                int i6 = i2;
                c cVar3 = cVar2;
                a a4 = a(str, i4, cVar.a(), i2, eVar);
                if (a4 == null) {
                    a4 = a(str, i5, cVar3.a(), i6, eVar);
                }
                if (a4 == null) {
                    return a.e.b();
                }
                bVar2.a(a4);
                i4 = i5 + 1;
                i2 = i6;
                cVar2 = cVar3;
            }
            int i7 = i2;
            c cVar4 = cVar2;
            byte[] b4 = bVar2.b();
            int i8 = 3;
            byte[] bArr2 = {"0".getBytes()[0], "O".getBytes()[0], "V".getBytes()[0]};
            int i9 = 0;
            while (true) {
                if (i9 >= i8) {
                    b2 = null;
                    break;
                }
                byte b5 = bArr2[i9];
                a a5 = a.a(b5, z2);
                int i10 = i9;
                byte[] bArr3 = bArr2;
                if (a(str, 32, a5, i7, eVar)) {
                    a a6 = a.a(b5, true);
                    if (a(str, 33, a6, i7, eVar)) {
                        b bVar3 = new b(this);
                        bVar3.a(a5);
                        bVar3.a(a6);
                        b2 = Byte.valueOf(bVar3.b()[0]);
                        break;
                    }
                }
                i9 = i10 + 1;
                bArr2 = bArr3;
                i8 = 3;
                z2 = false;
            }
            int i11 = 34;
            if (b2 == null) {
                b bVar4 = new b(this);
                int i12 = 32;
                while (i12 < 34) {
                    int i13 = i12;
                    a a7 = a(str, i12, cVar.a(), i7, eVar);
                    if (a7 == null) {
                        a7 = a(str, i13, cVar4.a(), i7, eVar);
                    }
                    if (a7 == null) {
                        return a.e.b();
                    }
                    bVar4.a(a7);
                    i12 = i13 + 1;
                }
                b3 = Byte.valueOf(bVar4.b()[0]);
                z = true;
            } else {
                z = false;
                b3 = b2;
            }
            if (z) {
                b bVar5 = new b(this);
                while (true) {
                    if (i11 >= 94) {
                        bVar = bVar5;
                        break;
                    }
                    bVar = bVar5;
                    a a8 = a(str, i11, cVar.a(), i7, eVar);
                    if (a8 == null) {
                        a8 = a(str, i11, cVar4.a(), i7, eVar);
                    }
                    if (a8 == null) {
                        break;
                    }
                    bVar.a(a8);
                    i11++;
                    bVar5 = bVar;
                }
                if (bVar.a() > 0) {
                    bArr = bVar.b();
                    a2 = new C1676d(b4, b3.byteValue(), bArr).a();
                    if (dVar.f42647a && gVar != null) {
                        gVar.a(System.currentTimeMillis());
                        gVar.b(packageInfo.lastUpdateTime);
                        gVar.a(str);
                        gVar.a(a2);
                        gVar.b();
                    }
                    return a.e.a(a2);
                }
            }
            bArr = null;
            a2 = new C1676d(b4, b3.byteValue(), bArr).a();
            if (dVar.f42647a) {
                gVar.a(System.currentTimeMillis());
                gVar.b(packageInfo.lastUpdateTime);
                gVar.a(str);
                gVar.a(a2);
                gVar.b();
            }
            return a.e.a(a2);
        }
        return (a.e) invokeLL.objValue;
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public void a(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f42669d = this.f42637a.f42641a;
            this.f42671f = this.f42638b.a("upc");
        }
    }
}
