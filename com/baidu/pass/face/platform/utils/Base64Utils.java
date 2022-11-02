package com.baidu.pass.face.platform.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.disklrucache.StrictLineReader;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes2.dex */
public class Base64Utils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;
        public int b;

        public a() {
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
    }

    /* loaded from: classes2.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public static final int[] c;
        public static final int[] d;
        public transient /* synthetic */ FieldHolder $fh;
        public int e;
        public int f;
        public final int[] g;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1224880013, "Lcom/baidu/pass/face/platform/utils/Base64Utils$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1224880013, "Lcom/baidu/pass/face/platform/utils/Base64Utils$b;");
                    return;
                }
            }
            c = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            d = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public b(int i, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bArr;
            this.g = (i & 8) == 0 ? c : d;
            this.e = 0;
            this.f = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0102, code lost:
            if (r5 != 4) goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                int i3 = this.e;
                if (i3 == 6) {
                    return false;
                }
                int i4 = i2 + i;
                int i5 = this.f;
                byte[] bArr2 = this.a;
                int[] iArr = this.g;
                int i6 = i5;
                int i7 = 0;
                int i8 = i3;
                int i9 = i;
                while (i9 < i4) {
                    if (i8 == 0) {
                        while (true) {
                            int i10 = i9 + 4;
                            if (i10 > i4 || (i6 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                                break;
                            }
                            bArr2[i7 + 2] = (byte) i6;
                            bArr2[i7 + 1] = (byte) (i6 >> 8);
                            bArr2[i7] = (byte) (i6 >> 16);
                            i7 += 3;
                            i9 = i10;
                        }
                        if (i9 >= i4) {
                            break;
                        }
                    }
                    int i11 = i9 + 1;
                    int i12 = iArr[bArr[i9] & 255];
                    if (i8 != 0) {
                        if (i8 == 1) {
                            if (i12 < 0) {
                                if (i12 != -1) {
                                    this.e = 6;
                                    return false;
                                }
                            }
                            i12 |= i6 << 6;
                        } else if (i8 == 2) {
                            if (i12 < 0) {
                                if (i12 == -2) {
                                    bArr2[i7] = (byte) (i6 >> 4);
                                    i7++;
                                    i8 = 4;
                                } else if (i12 != -1) {
                                    this.e = 6;
                                    return false;
                                }
                            }
                            i12 |= i6 << 6;
                        } else if (i8 != 3) {
                            if (i8 != 4) {
                                if (i8 == 5 && i12 != -1) {
                                    this.e = 6;
                                    return false;
                                }
                            } else if (i12 == -2) {
                                i8++;
                            } else if (i12 != -1) {
                                this.e = 6;
                                return false;
                            }
                        } else if (i12 >= 0) {
                            int i13 = i12 | (i6 << 6);
                            bArr2[i7 + 2] = (byte) i13;
                            bArr2[i7 + 1] = (byte) (i13 >> 8);
                            bArr2[i7] = (byte) (i13 >> 16);
                            i7 += 3;
                            i6 = i13;
                            i8 = 0;
                        } else if (i12 == -2) {
                            bArr2[i7 + 1] = (byte) (i6 >> 2);
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 += 2;
                            i8 = 5;
                        } else if (i12 != -1) {
                            break;
                        }
                        i8++;
                        i6 = i12;
                    } else {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.e = 6;
                                return false;
                            }
                        }
                        i8++;
                        i6 = i12;
                    }
                    i9 = i11;
                }
                if (z) {
                    if (i8 != 1) {
                        if (i8 == 2) {
                            bArr2[i7] = (byte) (i6 >> 4);
                            i7++;
                        } else if (i8 == 3) {
                            int i14 = i7 + 1;
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 = i14 + 1;
                            bArr2[i14] = (byte) (i6 >> 2);
                        }
                        this.e = i8;
                    }
                    this.e = 6;
                    return false;
                }
                this.e = i8;
                this.f = i6;
                this.b = i7;
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ boolean g;
        public static final byte[] h;
        public static final byte[] i;
        public transient /* synthetic */ FieldHolder $fh;
        public int c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final byte[] j;
        public int k;
        public final byte[] l;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1224879982, "Lcom/baidu/pass/face/platform/utils/Base64Utils$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1224879982, "Lcom/baidu/pass/face/platform/utils/Base64Utils$c;");
                    return;
                }
            }
            g = !Base64Utils.class.desiredAssertionStatus();
            h = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            i = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public c(int i2, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bArr;
            this.d = (i2 & 1) == 0;
            this.e = (i2 & 2) == 0;
            this.f = (i2 & 4) != 0;
            this.l = (i2 & 8) == 0 ? h : i;
            this.j = new byte[2];
            this.c = 0;
            this.k = this.e ? 19 : -1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
            if (r17.f == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
            r2[r6] = com.bumptech.glide.disklrucache.StrictLineReader.CR;
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00e1, code lost:
            r2[r6] = 10;
            r6 = r6 + 1;
            r11 = r10;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e1 -> B:24:0x008e). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            int i4;
            int i5;
            int i6;
            int i7;
            byte b;
            int i8;
            byte b2;
            byte b3;
            int i9;
            int i10;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
                return invokeCommon.booleanValue;
            }
            byte[] bArr2 = this.l;
            byte[] bArr3 = this.a;
            int i11 = this.k;
            int i12 = i3 + i2;
            int i13 = this.c;
            int i14 = 0;
            if (i13 != 1) {
                if (i13 == 2 && (i10 = i2 + 1) <= i12) {
                    byte[] bArr4 = this.j;
                    i5 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i2] & 255);
                    this.c = 0;
                    i4 = i10;
                }
                i4 = i2;
                i5 = -1;
            } else {
                if (i2 + 2 <= i12) {
                    int i15 = i2 + 1;
                    i4 = i15 + 1;
                    i5 = (bArr[i15] & 255) | ((this.j[0] & 255) << 16) | ((bArr[i2] & 255) << 8);
                    this.c = 0;
                }
                i4 = i2;
                i5 = -1;
            }
            if (i5 != -1) {
                bArr3[0] = bArr2[(i5 >> 18) & 63];
                bArr3[1] = bArr2[(i5 >> 12) & 63];
                bArr3[2] = bArr2[(i5 >> 6) & 63];
                bArr3[3] = bArr2[i5 & 63];
                i11--;
                if (i11 == 0) {
                    if (this.f) {
                        i9 = 5;
                        bArr3[4] = StrictLineReader.CR;
                    } else {
                        i9 = 4;
                    }
                    i6 = i9 + 1;
                    bArr3[i9] = 10;
                    i11 = 19;
                } else {
                    i6 = 4;
                }
            } else {
                i6 = 0;
            }
            while (true) {
                int i16 = i4 + 3;
                if (i16 > i12) {
                    if (z) {
                        int i17 = this.c;
                        if (i4 - i17 == i12 - 1) {
                            if (i17 > 0) {
                                b3 = this.j[0];
                                i14 = 1;
                            } else {
                                byte b4 = bArr[i4];
                                i4++;
                                b3 = b4;
                            }
                            int i18 = (b3 & 255) << 4;
                            this.c -= i14;
                            int i19 = i6 + 1;
                            bArr3[i6] = bArr2[(i18 >> 6) & 63];
                            i6 = i19 + 1;
                            bArr3[i19] = bArr2[i18 & 63];
                            if (this.d) {
                                int i20 = i6 + 1;
                                bArr3[i6] = BaseNCodec.PAD_DEFAULT;
                                i6 = i20 + 1;
                                bArr3[i20] = BaseNCodec.PAD_DEFAULT;
                            }
                            if (this.e) {
                                if (this.f) {
                                    bArr3[i6] = StrictLineReader.CR;
                                    i6++;
                                }
                                i7 = i6 + 1;
                                bArr3[i6] = 10;
                                i6 = i7;
                            }
                            if (g && this.c != 0) {
                                throw new AssertionError();
                            }
                            if (!g && i4 != i12) {
                                throw new AssertionError();
                            }
                        } else {
                            if (i4 - i17 == i12 - 2) {
                                if (i17 > 1) {
                                    b = this.j[0];
                                    i14 = 1;
                                } else {
                                    byte b5 = bArr[i4];
                                    i4++;
                                    b = b5;
                                }
                                int i21 = (b & 255) << 10;
                                if (this.c > 0) {
                                    i8 = i14 + 1;
                                    b2 = this.j[i14];
                                } else {
                                    i8 = i14;
                                    b2 = bArr[i4];
                                    i4++;
                                }
                                int i22 = i21 | ((b2 & 255) << 2);
                                this.c -= i8;
                                int i23 = i6 + 1;
                                bArr3[i6] = bArr2[(i22 >> 12) & 63];
                                int i24 = i23 + 1;
                                bArr3[i23] = bArr2[(i22 >> 6) & 63];
                                int i25 = i24 + 1;
                                bArr3[i24] = bArr2[i22 & 63];
                                if (this.d) {
                                    bArr3[i25] = BaseNCodec.PAD_DEFAULT;
                                    i25++;
                                }
                                if (this.e) {
                                    if (this.f) {
                                        bArr3[i25] = StrictLineReader.CR;
                                        i25++;
                                    }
                                    bArr3[i25] = 10;
                                    i25++;
                                }
                                i6 = i25;
                            } else if (this.e && i6 > 0 && i11 != 19) {
                                if (this.f) {
                                    bArr3[i6] = StrictLineReader.CR;
                                    i6++;
                                }
                                i7 = i6 + 1;
                                bArr3[i6] = 10;
                                i6 = i7;
                            }
                            if (g) {
                            }
                            if (!g) {
                                throw new AssertionError();
                            }
                        }
                    } else if (i4 == i12 - 1) {
                        byte[] bArr5 = this.j;
                        int i26 = this.c;
                        this.c = i26 + 1;
                        bArr5[i26] = bArr[i4];
                    } else if (i4 == i12 - 2) {
                        byte[] bArr6 = this.j;
                        int i27 = this.c;
                        int i28 = i27 + 1;
                        this.c = i28;
                        bArr6[i27] = bArr[i4];
                        this.c = i28 + 1;
                        bArr6[i28] = bArr[i4 + 1];
                    }
                    this.b = i6;
                    this.k = i11;
                    return true;
                }
                int i29 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16) | (bArr[i4 + 2] & 255);
                bArr3[i6] = bArr2[(i29 >> 18) & 63];
                bArr3[i6 + 1] = bArr2[(i29 >> 12) & 63];
                bArr3[i6 + 2] = bArr2[(i29 >> 6) & 63];
                bArr3[i6 + 3] = bArr2[i29 & 63];
                i6 += 4;
                i11--;
                if (i11 == 0) {
                    break;
                }
                i4 = i16;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-126414095, "Lcom/baidu/pass/face/platform/utils/Base64Utils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-126414095, "Lcom/baidu/pass/face/platform/utils/Base64Utils;");
        }
    }

    public Base64Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static byte[] decode(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) ? decode(str.getBytes(), i) : (byte[]) invokeLI.objValue;
    }

    public static byte[] decode(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i)) == null) ? decode(bArr, 0, bArr.length, i) : (byte[]) invokeLI.objValue;
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2, i3)) == null) {
            b bVar = new b(i3, new byte[(i2 * 3) / 4]);
            if (bVar.a(bArr, i, i2, true)) {
                int i4 = bVar.b;
                byte[] bArr2 = bVar.a;
                if (i4 == bArr2.length) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i4];
                System.arraycopy(bArr2, 0, bArr3, 0, i4);
                return bArr3;
            }
            throw new IllegalArgumentException("bad base-64");
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static byte[] encode(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, bArr, i)) == null) ? encode(bArr, 0, bArr.length, i) : (byte[]) invokeLI.objValue;
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, bArr, i, i2, i3)) == null) {
            c cVar = new c(i3, null);
            int i4 = (i2 / 3) * 4;
            if (!cVar.d) {
                int i5 = i2 % 3;
                if (i5 == 1) {
                    i4 += 2;
                } else if (i5 == 2) {
                    i4 += 3;
                }
            } else if (i2 % 3 > 0) {
                i4 += 4;
            }
            if (cVar.e && i2 > 0) {
                i4 += (((i2 - 1) / 57) + 1) * (cVar.f ? 2 : 1);
            }
            cVar.a = new byte[i4];
            cVar.a(bArr, i, i2, true);
            return cVar.a;
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static String encodeToString(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bArr, i)) == null) {
            try {
                return new String(encode(bArr, i), "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, bArr, i, i2, i3)) == null) {
            try {
                return new String(encode(bArr, i, i2, i3), "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeLIII.objValue;
    }
}
