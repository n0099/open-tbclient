package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ad extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ac f41984a;

    public ad(ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {acVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41984a = acVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ff, code lost:
        if (r13 != null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0101, code lost:
        r13 = r12.f41984a.f41982h;
        r13.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0113, code lost:
        if (r13 != null) goto L118;
     */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        e eVar6;
        e eVar7;
        e eVar8;
        e eVar9;
        e eVar10;
        e eVar11;
        e eVar12;
        e eVar13;
        e eVar14;
        e eVar15;
        e eVar16;
        e eVar17;
        e eVar18;
        e eVar19;
        m mVar;
        m mVar2;
        e eVar20;
        e eVar21;
        e eVar22;
        e eVar23;
        e eVar24;
        e eVar25;
        e eVar26;
        e eVar27;
        e eVar28;
        e eVar29;
        e eVar30;
        e eVar31;
        e eVar32;
        e eVar33;
        e eVar34;
        e eVar35;
        e eVar36;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            eVar = this.f41984a.f41983i;
            if (eVar != null) {
                eVar2 = this.f41984a.f41983i;
                if (eVar2.f42012i == null) {
                    return;
                }
                long longValue = ((Long) message.obj).longValue();
                eVar3 = this.f41984a.f41983i;
                if (longValue != eVar3.f42013j) {
                    return;
                }
                int i2 = message.what;
                if (i2 == 4000) {
                    eVar33 = this.f41984a.f41983i;
                    if (eVar33.f42011h == null) {
                        return;
                    }
                    eVar34 = this.f41984a.f41983i;
                    for (l lVar : eVar34.f42011h) {
                        Bitmap bitmap = null;
                        if (message.arg2 == 1) {
                            int[] iArr = new int[ac.f41975a * ac.f41976b];
                            int[] iArr2 = new int[ac.f41975a * ac.f41976b];
                            eVar35 = this.f41984a.f41983i;
                            if (eVar35.f42012i == null) {
                                return;
                            }
                            eVar36 = this.f41984a.f41983i;
                            int[] a2 = eVar36.f42012i.a(iArr, ac.f41975a, ac.f41976b);
                            for (int i3 = 0; i3 < ac.f41976b; i3++) {
                                int i4 = 0;
                                while (true) {
                                    int i5 = ac.f41975a;
                                    if (i4 < i5) {
                                        int i6 = a2[(i5 * i3) + i4];
                                        iArr2[(((ac.f41976b - i3) - 1) * ac.f41975a) + i4] = (i6 & (-16711936)) | ((i6 << 16) & 16711680) | ((i6 >> 16) & 255);
                                        i4++;
                                    }
                                }
                            }
                            bitmap = Bitmap.createBitmap(iArr2, ac.f41975a, ac.f41976b, Bitmap.Config.ARGB_8888);
                        }
                        if (lVar != null) {
                            lVar.a(bitmap);
                        }
                    }
                } else if (i2 == 39) {
                    eVar17 = this.f41984a.f41983i;
                    if (eVar17 == null) {
                        return;
                    }
                    int i7 = message.arg1;
                    if (i7 == 100) {
                        eVar32 = this.f41984a.f41983i;
                        eVar32.B();
                    } else if (i7 == 200) {
                        eVar20 = this.f41984a.f41983i;
                        eVar20.L();
                    } else if (i7 == 1) {
                        mVar2 = this.f41984a.f41982h;
                    } else if (i7 == 0) {
                        mVar = this.f41984a.f41982h;
                    } else if (i7 == 2) {
                        eVar18 = this.f41984a.f41983i;
                        if (eVar18.f42011h == null) {
                            return;
                        }
                        eVar19 = this.f41984a.f41983i;
                        for (l lVar2 : eVar19.f42011h) {
                            if (lVar2 != null) {
                                lVar2.c();
                            }
                        }
                    }
                    eVar21 = this.f41984a.f41983i;
                    if (!eVar21.k && ac.f41976b > 0 && ac.f41975a > 0) {
                        eVar28 = this.f41984a.f41983i;
                        if (eVar28.b(0, 0) != null) {
                            eVar29 = this.f41984a.f41983i;
                            eVar29.k = true;
                            eVar30 = this.f41984a.f41983i;
                            if (eVar30.f42011h == null) {
                                return;
                            }
                            eVar31 = this.f41984a.f41983i;
                            for (l lVar3 : eVar31.f42011h) {
                                if (lVar3 != null) {
                                    lVar3.b();
                                }
                            }
                        }
                    }
                    eVar22 = this.f41984a.f41983i;
                    if (eVar22.f42011h == null) {
                        return;
                    }
                    eVar23 = this.f41984a.f41983i;
                    for (l lVar4 : eVar23.f42011h) {
                        if (lVar4 != null) {
                            lVar4.a();
                        }
                    }
                    eVar24 = this.f41984a.f41983i;
                    if (eVar24.q()) {
                        eVar25 = this.f41984a.f41983i;
                        if (eVar25.f42011h == null) {
                            return;
                        }
                        eVar26 = this.f41984a.f41983i;
                        for (l lVar5 : eVar26.f42011h) {
                            if (lVar5 != null) {
                                eVar27 = this.f41984a.f41983i;
                                if (eVar27.E().f41956a >= 18.0f) {
                                    lVar5.a(true);
                                } else {
                                    lVar5.a(false);
                                }
                            }
                        }
                    }
                } else if (i2 == 41) {
                    eVar9 = this.f41984a.f41983i;
                    if (eVar9 == null) {
                        return;
                    }
                    eVar10 = this.f41984a.f41983i;
                    if (!eVar10.n) {
                        eVar16 = this.f41984a.f41983i;
                        if (!eVar16.o) {
                            return;
                        }
                    }
                    eVar11 = this.f41984a.f41983i;
                    if (eVar11.f42011h == null) {
                        return;
                    }
                    eVar12 = this.f41984a.f41983i;
                    for (l lVar6 : eVar12.f42011h) {
                        if (lVar6 != null) {
                            eVar13 = this.f41984a.f41983i;
                            lVar6.b(eVar13.E());
                            eVar14 = this.f41984a.f41983i;
                            if (eVar14.q()) {
                                eVar15 = this.f41984a.f41983i;
                                if (eVar15.E().f41956a >= 18.0f) {
                                    lVar6.a(true);
                                } else {
                                    lVar6.a(false);
                                }
                            }
                        }
                    }
                } else if (i2 == 999) {
                    eVar7 = this.f41984a.f41983i;
                    if (eVar7.f42011h == null) {
                        return;
                    }
                    eVar8 = this.f41984a.f41983i;
                    for (l lVar7 : eVar8.f42011h) {
                        if (lVar7 != null) {
                            lVar7.e();
                        }
                    }
                } else if (i2 == 50) {
                    eVar4 = this.f41984a.f41983i;
                    if (eVar4.f42011h == null) {
                        return;
                    }
                    eVar5 = this.f41984a.f41983i;
                    for (l lVar8 : eVar5.f42011h) {
                        if (lVar8 != null) {
                            int i8 = message.arg1;
                            if (i8 != 0) {
                                if (i8 == 1) {
                                    eVar6 = this.f41984a.f41983i;
                                    if (eVar6.E().f41956a >= 18.0f) {
                                        lVar8.a(true);
                                    }
                                }
                            }
                            lVar8.a(false);
                        }
                    }
                }
            }
        }
    }
}
