package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import androidx.recyclerview.widget.ItemTouchHelper;
/* loaded from: classes2.dex */
public class k extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f7700a;

    public k(j jVar) {
        this.f7700a = jVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:23:0x009b */
    /* JADX WARN: Incorrect condition in loop: B:26:0x00a4 */
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
        e eVar20;
        e eVar21;
        e eVar22;
        int i2;
        int i3;
        e eVar23;
        e eVar24;
        e eVar25;
        e eVar26;
        e eVar27;
        e eVar28;
        int i4;
        int i5;
        int i6;
        int i7;
        e eVar29;
        e eVar30;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        super.handleMessage(message);
        eVar = this.f7700a.f7691g;
        if (eVar == null) {
            return;
        }
        long longValue = ((Long) message.obj).longValue();
        eVar2 = this.f7700a.f7691g;
        if (longValue != eVar2.j) {
            return;
        }
        int i17 = message.what;
        boolean z = true;
        int i18 = 0;
        if (i17 == 4000) {
            eVar27 = this.f7700a.f7691g;
            if (eVar27.f7667h == null) {
                return;
            }
            eVar28 = this.f7700a.f7691g;
            for (l lVar : eVar28.f7667h) {
                Bitmap bitmap = null;
                if (message.arg2 == 1) {
                    i4 = this.f7700a.f7688d;
                    i5 = this.f7700a.f7689e;
                    int[] iArr = new int[i4 * i5];
                    i6 = this.f7700a.f7688d;
                    i7 = this.f7700a.f7689e;
                    int[] iArr2 = new int[i6 * i7];
                    eVar29 = this.f7700a.f7691g;
                    if (eVar29.f7668i == null) {
                        return;
                    }
                    eVar30 = this.f7700a.f7691g;
                    com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = eVar30.f7668i;
                    i8 = this.f7700a.f7688d;
                    i9 = this.f7700a.f7689e;
                    int[] a2 = aVar.a(iArr, i8, i9);
                    for (int i19 = 0; i19 < i10; i19++) {
                        for (int i20 = 0; i20 < i13; i20++) {
                            i14 = this.f7700a.f7688d;
                            int i21 = a2[(i14 * i19) + i20];
                            i15 = this.f7700a.f7689e;
                            i16 = this.f7700a.f7688d;
                            iArr2[(((i15 - i19) - 1) * i16) + i20] = (i21 & (-16711936)) | ((i21 << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((i21 >> 16) & 255);
                        }
                    }
                    i11 = this.f7700a.f7688d;
                    i12 = this.f7700a.f7689e;
                    bitmap = Bitmap.createBitmap(iArr2, i11, i12, Bitmap.Config.RGB_565);
                }
                if (lVar != null) {
                    lVar.a(bitmap);
                }
            }
        } else if (i17 == 39) {
            eVar15 = this.f7700a.f7691g;
            if (eVar15 == null) {
                return;
            }
            eVar16 = this.f7700a.f7691g;
            if (eVar16.f7667h == null) {
                return;
            }
            int i22 = message.arg1;
            if (i22 == 100) {
                eVar26 = this.f7700a.f7691g;
                eVar26.B();
            } else if (i22 == 200) {
                eVar20 = this.f7700a.f7691g;
                eVar20.L();
            } else if (i22 == 1) {
                this.f7700a.requestRender();
            } else if (i22 == 0) {
                this.f7700a.requestRender();
                eVar19 = this.f7700a.f7691g;
                if (!eVar19.b() && this.f7700a.getRenderMode() != 0) {
                    this.f7700a.setRenderMode(0);
                }
            } else if (i22 == 2) {
                eVar17 = this.f7700a.f7691g;
                if (eVar17.f7667h == null) {
                    return;
                }
                eVar18 = this.f7700a.f7691g;
                for (l lVar2 : eVar18.f7667h) {
                    if (lVar2 != null) {
                        lVar2.c();
                    }
                }
            }
            eVar21 = this.f7700a.f7691g;
            if (!eVar21.k) {
                i2 = this.f7700a.f7689e;
                if (i2 > 0) {
                    i3 = this.f7700a.f7688d;
                    if (i3 > 0) {
                        eVar23 = this.f7700a.f7691g;
                        if (eVar23.b(0, 0) != null) {
                            eVar24 = this.f7700a.f7691g;
                            eVar24.k = true;
                            eVar25 = this.f7700a.f7691g;
                            for (l lVar3 : eVar25.f7667h) {
                                if (lVar3 != null) {
                                    lVar3.b();
                                }
                            }
                        }
                    }
                }
            }
            eVar22 = this.f7700a.f7691g;
            for (l lVar4 : eVar22.f7667h) {
                if (lVar4 != null) {
                    lVar4.a();
                }
            }
        } else if (i17 == 41) {
            eVar9 = this.f7700a.f7691g;
            if (eVar9 == null) {
                return;
            }
            eVar10 = this.f7700a.f7691g;
            if (eVar10.f7667h == null) {
                return;
            }
            eVar11 = this.f7700a.f7691g;
            if (!eVar11.n) {
                eVar14 = this.f7700a.f7691g;
                if (!eVar14.o) {
                    return;
                }
            }
            eVar12 = this.f7700a.f7691g;
            for (l lVar5 : eVar12.f7667h) {
                if (lVar5 != null) {
                    eVar13 = this.f7700a.f7691g;
                    lVar5.b(eVar13.E());
                }
            }
        } else if (i17 == 999) {
            eVar7 = this.f7700a.f7691g;
            if (eVar7.f7667h == null) {
                return;
            }
            eVar8 = this.f7700a.f7691g;
            for (l lVar6 : eVar8.f7667h) {
                if (lVar6 != null) {
                    lVar6.e();
                }
            }
        } else if (i17 == 50) {
            eVar4 = this.f7700a.f7691g;
            if (eVar4.f7667h == null) {
                return;
            }
            eVar5 = this.f7700a.f7691g;
            for (l lVar7 : eVar5.f7667h) {
                if (lVar7 != null) {
                    int i23 = message.arg1;
                    if (i23 != 0) {
                        if (i23 == 1) {
                            eVar6 = this.f7700a.f7691g;
                            if (eVar6.E().f7614a >= 18.0f) {
                                lVar7.a(true);
                            }
                        }
                    }
                    lVar7.a(false);
                }
            }
        } else if (i17 == 65289) {
            int i24 = message.arg2;
            if (message.arg1 == 300) {
                if (i24 != 1003) {
                    if (i24 >= 1004) {
                    }
                    i18 = i24;
                    z = false;
                }
                eVar3 = this.f7700a.f7691g;
                for (l lVar8 : eVar3.f7667h) {
                    if (lVar8 != null) {
                        lVar8.a(z, i18);
                    }
                }
            }
        }
    }
}
