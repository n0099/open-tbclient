package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import androidx.recyclerview.widget.ItemTouchHelper;
/* loaded from: classes2.dex */
public class k extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f7960a;

    public k(j jVar) {
        this.f7960a = jVar;
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
        e eVar23;
        e eVar24;
        e eVar25;
        e eVar26;
        int i2;
        int i3;
        e eVar27;
        e eVar28;
        e eVar29;
        e eVar30;
        e eVar31;
        e eVar32;
        int i4;
        int i5;
        int i6;
        int i7;
        e eVar33;
        e eVar34;
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
        eVar = this.f7960a.f7951g;
        if (eVar == null) {
            return;
        }
        long longValue = ((Long) message.obj).longValue();
        eVar2 = this.f7960a.f7951g;
        if (longValue != eVar2.j) {
            return;
        }
        int i17 = message.what;
        if (i17 == 4000) {
            eVar31 = this.f7960a.f7951g;
            if (eVar31.f7927h == null) {
                return;
            }
            eVar32 = this.f7960a.f7951g;
            for (l lVar : eVar32.f7927h) {
                Bitmap bitmap = null;
                if (message.arg2 == 1) {
                    i4 = this.f7960a.f7948d;
                    i5 = this.f7960a.f7949e;
                    int[] iArr = new int[i4 * i5];
                    i6 = this.f7960a.f7948d;
                    i7 = this.f7960a.f7949e;
                    int[] iArr2 = new int[i6 * i7];
                    eVar33 = this.f7960a.f7951g;
                    if (eVar33.f7928i == null) {
                        return;
                    }
                    eVar34 = this.f7960a.f7951g;
                    com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = eVar34.f7928i;
                    i8 = this.f7960a.f7948d;
                    i9 = this.f7960a.f7949e;
                    int[] a2 = aVar.a(iArr, i8, i9);
                    for (int i18 = 0; i18 < i10; i18++) {
                        for (int i19 = 0; i19 < i13; i19++) {
                            i14 = this.f7960a.f7948d;
                            int i20 = a2[(i14 * i18) + i19];
                            i15 = this.f7960a.f7949e;
                            i16 = this.f7960a.f7948d;
                            iArr2[(((i15 - i18) - 1) * i16) + i19] = (i20 & (-16711936)) | ((i20 << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((i20 >> 16) & 255);
                        }
                    }
                    i11 = this.f7960a.f7948d;
                    i12 = this.f7960a.f7949e;
                    bitmap = Bitmap.createBitmap(iArr2, i11, i12, Bitmap.Config.RGB_565);
                }
                if (lVar != null) {
                    lVar.a(bitmap);
                }
            }
        } else if (i17 == 39) {
            eVar16 = this.f7960a.f7951g;
            if (eVar16 == null) {
                return;
            }
            eVar17 = this.f7960a.f7951g;
            if (eVar17.f7927h == null) {
                return;
            }
            int i21 = message.arg1;
            if (i21 == 100) {
                eVar30 = this.f7960a.f7951g;
                eVar30.B();
            } else if (i21 == 200) {
                eVar21 = this.f7960a.f7951g;
                eVar21.K();
            } else if (i21 == 1) {
                this.f7960a.requestRender();
            } else if (i21 == 0) {
                this.f7960a.requestRender();
                eVar20 = this.f7960a.f7951g;
                if (!eVar20.b() && this.f7960a.getRenderMode() != 0) {
                    this.f7960a.setRenderMode(0);
                }
            } else if (i21 == 2) {
                eVar18 = this.f7960a.f7951g;
                if (eVar18.f7927h == null) {
                    return;
                }
                eVar19 = this.f7960a.f7951g;
                for (l lVar2 : eVar19.f7927h) {
                    if (lVar2 != null) {
                        lVar2.c();
                    }
                }
            }
            eVar22 = this.f7960a.f7951g;
            if (!eVar22.k) {
                i2 = this.f7960a.f7949e;
                if (i2 > 0) {
                    i3 = this.f7960a.f7948d;
                    if (i3 > 0) {
                        eVar27 = this.f7960a.f7951g;
                        if (eVar27.b(0, 0) != null) {
                            eVar28 = this.f7960a.f7951g;
                            eVar28.k = true;
                            eVar29 = this.f7960a.f7951g;
                            for (l lVar3 : eVar29.f7927h) {
                                if (lVar3 != null) {
                                    lVar3.b();
                                }
                            }
                        }
                    }
                }
            }
            eVar23 = this.f7960a.f7951g;
            for (l lVar4 : eVar23.f7927h) {
                if (lVar4 != null) {
                    lVar4.a();
                }
            }
            eVar24 = this.f7960a.f7951g;
            if (eVar24.q()) {
                eVar25 = this.f7960a.f7951g;
                for (l lVar5 : eVar25.f7927h) {
                    eVar26 = this.f7960a.f7951g;
                    if (eVar26.E().f7874a >= 18.0f) {
                        if (lVar5 != null) {
                            lVar5.a(true);
                        }
                    } else if (lVar5 != null) {
                        lVar5.a(false);
                    }
                }
            }
        } else if (i17 == 41) {
            eVar8 = this.f7960a.f7951g;
            if (eVar8 == null) {
                return;
            }
            eVar9 = this.f7960a.f7951g;
            if (eVar9.f7927h == null) {
                return;
            }
            eVar10 = this.f7960a.f7951g;
            if (!eVar10.n) {
                eVar15 = this.f7960a.f7951g;
                if (!eVar15.o) {
                    return;
                }
            }
            eVar11 = this.f7960a.f7951g;
            for (l lVar6 : eVar11.f7927h) {
                if (lVar6 != null) {
                    eVar12 = this.f7960a.f7951g;
                    lVar6.b(eVar12.E());
                    eVar13 = this.f7960a.f7951g;
                    if (eVar13.q()) {
                        eVar14 = this.f7960a.f7951g;
                        if (eVar14.E().f7874a >= 18.0f) {
                            lVar6.a(true);
                        } else {
                            lVar6.a(false);
                        }
                    }
                }
            }
        } else if (i17 == 999) {
            eVar6 = this.f7960a.f7951g;
            if (eVar6.f7927h == null) {
                return;
            }
            eVar7 = this.f7960a.f7951g;
            for (l lVar7 : eVar7.f7927h) {
                if (lVar7 != null) {
                    lVar7.e();
                }
            }
        } else if (i17 == 50) {
            eVar3 = this.f7960a.f7951g;
            if (eVar3.f7927h == null) {
                return;
            }
            eVar4 = this.f7960a.f7951g;
            for (l lVar8 : eVar4.f7927h) {
                if (lVar8 != null) {
                    int i22 = message.arg1;
                    if (i22 != 0) {
                        if (i22 == 1) {
                            eVar5 = this.f7960a.f7951g;
                            if (eVar5.E().f7874a >= 18.0f) {
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
