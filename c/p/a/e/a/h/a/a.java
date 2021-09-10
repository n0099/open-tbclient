package c.p.a.e.a.h.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.f.a.h;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class a implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f34989a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34990b;

    /* renamed from: c  reason: collision with root package name */
    public e f34991c;

    /* renamed from: d  reason: collision with root package name */
    public C1546a f34992d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34993e;

    /* renamed from: f  reason: collision with root package name */
    public int f34994f;

    /* renamed from: g  reason: collision with root package name */
    public int f34995g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f34996h;

    /* renamed from: i  reason: collision with root package name */
    public int f34997i;

    /* renamed from: c.p.a.e.a.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1546a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int[] f34998a;

        /* renamed from: b  reason: collision with root package name */
        public int f34999b;

        /* renamed from: c  reason: collision with root package name */
        public int f35000c;

        public C1546a() {
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
            this.f34998a = new int[32];
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34999b = 0;
                this.f35000c = 0;
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int[] iArr = this.f34998a;
                int length = iArr.length;
                int i3 = this.f34999b;
                int i4 = length - i3;
                if (i4 <= i2) {
                    int[] iArr2 = new int[(iArr.length + i4) * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i3);
                    this.f34998a = iArr2;
                }
            }
        }

        public final void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                if (this.f35000c == 0) {
                    g();
                }
                b(2);
                int i4 = this.f34999b;
                int i5 = i4 - 1;
                int[] iArr = this.f34998a;
                int i6 = iArr[i5];
                int i7 = i6 + 1;
                iArr[(i5 - 1) - (i6 * 2)] = i7;
                iArr[i5] = i2;
                iArr[i5 + 1] = i3;
                iArr[i5 + 2] = i7;
                this.f34999b = i4 + 2;
            }
        }

        public final int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i2 = this.f34999b;
                if (i2 == 0) {
                    return 0;
                }
                return this.f34998a[i2 - 1];
            }
            return invokeV.intValue;
        }

        public final boolean e() {
            InterceptResult invokeV;
            int i2;
            int[] iArr;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                int i4 = this.f34999b;
                if (i4 == 0 || (i3 = (iArr = this.f34998a)[i4 - 1]) == 0) {
                    return false;
                }
                int i5 = i3 - 1;
                int i6 = i2 - 2;
                iArr[i6] = i5;
                iArr[i6 - ((i5 * 2) + 1)] = i5;
                this.f34999b = i4 - 2;
                return true;
            }
            return invokeV.booleanValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35000c : invokeV.intValue;
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                b(2);
                int i2 = this.f34999b;
                int[] iArr = this.f34998a;
                iArr[i2] = 0;
                iArr[i2 + 1] = 0;
                this.f34999b = i2 + 2;
                this.f35000c++;
            }
        }

        public final void h() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (i2 = this.f34999b) == 0) {
                return;
            }
            int i3 = i2 - 1;
            int i4 = this.f34998a[i3] * 2;
            if ((i3 - 1) - i4 != 0) {
                this.f34999b = i2 - (i4 + 2);
                this.f35000c--;
            }
        }
    }

    public a() {
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
        this.f34990b = false;
        this.f34992d = new C1546a();
        k();
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.f34996h[j(i2) + 1];
            return i3 == -1 ? "" : this.f34991c.c(i3);
        }
        return (String) invokeI.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f34990b) {
            this.f34990b = false;
            this.f34989a.b();
            this.f34989a = null;
            this.f34991c = null;
            this.f34992d.a();
            k();
        }
    }

    public void c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, inputStream) == null) {
            b();
            if (inputStream != null) {
                this.f34989a = new c(inputStream, false);
            }
        }
    }

    @Override // c.p.a.e.a.h.a.f
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "XML line #" + c();
        }
        return (String) invokeV.objValue;
    }

    public int e() throws h, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f34989a != null) {
                try {
                    l();
                    return this.f34994f;
                } catch (IOException e2) {
                    b();
                    throw e2;
                }
            }
            throw new h("Parser is not opened.", this, null);
        }
        return invokeV.intValue;
    }

    @Override // c.p.a.e.a.h.a.f
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.f34996h[j(i2) + 3] : invokeI.intValue;
    }

    public int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.f34996h[j(i2) + 4] : invokeI.intValue;
    }

    public String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int j2 = j(i2);
            int[] iArr = this.f34996h;
            if (iArr[j2 + 3] == 3) {
                return this.f34991c.c(iArr[j2 + 2]);
            }
            int i3 = iArr[j2 + 4];
            return "";
        }
        return (String) invokeI.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f34994f != 2) {
                return -1;
            }
            return this.f34996h.length / 5;
        }
        return invokeV.intValue;
    }

    public final int j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (this.f34994f == 2) {
                int i3 = i2 * 5;
                if (i3 < this.f34996h.length) {
                    return i3;
                }
                throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
            }
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        return invokeI.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f34994f = -1;
            this.f34995g = -1;
            this.f34996h = null;
            this.f34997i = -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0176, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l() throws IOException {
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f34991c == null) {
                b.a(this.f34989a, 524291);
                this.f34989a.g();
                this.f34991c = e.b(this.f34989a);
                this.f34992d.g();
                this.f34990b = true;
            }
            int i2 = this.f34994f;
            if (i2 != 1) {
                k();
                while (true) {
                    if (this.f34993e) {
                        this.f34993e = false;
                        this.f34992d.h();
                    }
                    int i3 = 3;
                    if (i2 == 3 && this.f34992d.f() == 1 && this.f34992d.d() == 0) {
                        this.f34994f = 1;
                        return;
                    }
                    int e3 = i2 == 0 ? 1048834 : this.f34989a.e();
                    if (e3 == 524672) {
                        e2 = this.f34989a.e();
                        if (e2 < 8 || e2 % 4 != 0) {
                            break;
                        }
                        this.f34989a.f((e2 / 4) - 2);
                    } else if (e3 < 1048832 || e3 > 1048836) {
                        break;
                    } else if (e3 == 1048834 && i2 == -1) {
                        this.f34994f = 0;
                        return;
                    } else {
                        this.f34989a.g();
                        int e4 = this.f34989a.e();
                        this.f34989a.g();
                        if (e3 != 1048832 && e3 != 1048833) {
                            this.f34995g = e4;
                            if (e3 == 1048834) {
                                this.f34989a.e();
                                this.f34989a.e();
                                this.f34989a.g();
                                int e5 = this.f34989a.e();
                                this.f34997i = e5;
                                this.f34997i = (65535 & e5) - 1;
                                this.f34996h = this.f34989a.f((this.f34989a.e() & 65535) * 5);
                                while (true) {
                                    int[] iArr = this.f34996h;
                                    if (i3 < iArr.length) {
                                        iArr[i3] = iArr[i3] >>> 24;
                                        i3 += 5;
                                    } else {
                                        this.f34992d.g();
                                        this.f34994f = 2;
                                        return;
                                    }
                                }
                            } else if (e3 == 1048835) {
                                this.f34989a.e();
                                this.f34989a.e();
                                this.f34994f = 3;
                                this.f34993e = true;
                                return;
                            } else if (e3 == 1048836) {
                                this.f34989a.e();
                                this.f34989a.g();
                                this.f34989a.g();
                                this.f34994f = 4;
                                return;
                            }
                        } else if (e3 == 1048832) {
                            this.f34992d.c(this.f34989a.e(), this.f34989a.e());
                        } else {
                            this.f34989a.g();
                            this.f34989a.g();
                            this.f34992d.e();
                        }
                    }
                }
                throw new IOException("Invalid resource ids size (" + e2 + ").");
            }
        }
    }

    @Override // c.p.a.e.a.h.a.f
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34995g : invokeV.intValue;
    }
}
