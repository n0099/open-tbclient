package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import androidx.recyclerview.widget.ItemTouchHelper;
/* loaded from: classes2.dex */
public class k extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f7649a;

    public k(j jVar) {
        this.f7649a = jVar;
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
        int i;
        int i2;
        e eVar27;
        e eVar28;
        e eVar29;
        e eVar30;
        e eVar31;
        e eVar32;
        int i3;
        int i4;
        int i5;
        int i6;
        e eVar33;
        e eVar34;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        super.handleMessage(message);
        eVar = this.f7649a.f7640g;
        if (eVar == null) {
            return;
        }
        long longValue = ((Long) message.obj).longValue();
        eVar2 = this.f7649a.f7640g;
        if (longValue != eVar2.j) {
            return;
        }
        int i16 = message.what;
        if (i16 == 4000) {
            eVar31 = this.f7649a.f7640g;
            if (eVar31.f7618h == null) {
                return;
            }
            eVar32 = this.f7649a.f7640g;
            for (l lVar : eVar32.f7618h) {
                Bitmap bitmap = null;
                if (message.arg2 == 1) {
                    i3 = this.f7649a.f7637d;
                    i4 = this.f7649a.f7638e;
                    int[] iArr = new int[i3 * i4];
                    i5 = this.f7649a.f7637d;
                    i6 = this.f7649a.f7638e;
                    int[] iArr2 = new int[i5 * i6];
                    eVar33 = this.f7649a.f7640g;
                    if (eVar33.i == null) {
                        return;
                    }
                    eVar34 = this.f7649a.f7640g;
                    com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = eVar34.i;
                    i7 = this.f7649a.f7637d;
                    i8 = this.f7649a.f7638e;
                    int[] a2 = aVar.a(iArr, i7, i8);
                    for (int i17 = 0; i17 < i9; i17++) {
                        for (int i18 = 0; i18 < i12; i18++) {
                            i13 = this.f7649a.f7637d;
                            int i19 = a2[(i13 * i17) + i18];
                            i14 = this.f7649a.f7638e;
                            i15 = this.f7649a.f7637d;
                            iArr2[(((i14 - i17) - 1) * i15) + i18] = (i19 & (-16711936)) | ((i19 << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((i19 >> 16) & 255);
                        }
                    }
                    i10 = this.f7649a.f7637d;
                    i11 = this.f7649a.f7638e;
                    bitmap = Bitmap.createBitmap(iArr2, i10, i11, Bitmap.Config.RGB_565);
                }
                if (lVar != null) {
                    lVar.a(bitmap);
                }
            }
        } else if (i16 == 39) {
            eVar16 = this.f7649a.f7640g;
            if (eVar16 == null) {
                return;
            }
            eVar17 = this.f7649a.f7640g;
            if (eVar17.f7618h == null) {
                return;
            }
            int i20 = message.arg1;
            if (i20 == 100) {
                eVar30 = this.f7649a.f7640g;
                eVar30.B();
            } else if (i20 == 200) {
                eVar21 = this.f7649a.f7640g;
                eVar21.K();
            } else if (i20 == 1) {
                this.f7649a.requestRender();
            } else if (i20 == 0) {
                this.f7649a.requestRender();
                eVar20 = this.f7649a.f7640g;
                if (!eVar20.b() && this.f7649a.getRenderMode() != 0) {
                    this.f7649a.setRenderMode(0);
                }
            } else if (i20 == 2) {
                eVar18 = this.f7649a.f7640g;
                if (eVar18.f7618h == null) {
                    return;
                }
                eVar19 = this.f7649a.f7640g;
                for (l lVar2 : eVar19.f7618h) {
                    if (lVar2 != null) {
                        lVar2.c();
                    }
                }
            }
            eVar22 = this.f7649a.f7640g;
            if (!eVar22.k) {
                i = this.f7649a.f7638e;
                if (i > 0) {
                    i2 = this.f7649a.f7637d;
                    if (i2 > 0) {
                        eVar27 = this.f7649a.f7640g;
                        if (eVar27.b(0, 0) != null) {
                            eVar28 = this.f7649a.f7640g;
                            eVar28.k = true;
                            eVar29 = this.f7649a.f7640g;
                            for (l lVar3 : eVar29.f7618h) {
                                if (lVar3 != null) {
                                    lVar3.b();
                                }
                            }
                        }
                    }
                }
            }
            eVar23 = this.f7649a.f7640g;
            for (l lVar4 : eVar23.f7618h) {
                if (lVar4 != null) {
                    lVar4.a();
                }
            }
            eVar24 = this.f7649a.f7640g;
            if (eVar24.q()) {
                eVar25 = this.f7649a.f7640g;
                for (l lVar5 : eVar25.f7618h) {
                    eVar26 = this.f7649a.f7640g;
                    if (eVar26.E().f7569a >= 18.0f) {
                        if (lVar5 != null) {
                            lVar5.a(true);
                        }
                    } else if (lVar5 != null) {
                        lVar5.a(false);
                    }
                }
            }
        } else if (i16 == 41) {
            eVar8 = this.f7649a.f7640g;
            if (eVar8 == null) {
                return;
            }
            eVar9 = this.f7649a.f7640g;
            if (eVar9.f7618h == null) {
                return;
            }
            eVar10 = this.f7649a.f7640g;
            if (!eVar10.n) {
                eVar15 = this.f7649a.f7640g;
                if (!eVar15.o) {
                    return;
                }
            }
            eVar11 = this.f7649a.f7640g;
            for (l lVar6 : eVar11.f7618h) {
                if (lVar6 != null) {
                    eVar12 = this.f7649a.f7640g;
                    lVar6.b(eVar12.E());
                    eVar13 = this.f7649a.f7640g;
                    if (eVar13.q()) {
                        eVar14 = this.f7649a.f7640g;
                        if (eVar14.E().f7569a >= 18.0f) {
                            lVar6.a(true);
                        } else {
                            lVar6.a(false);
                        }
                    }
                }
            }
        } else if (i16 == 999) {
            eVar6 = this.f7649a.f7640g;
            if (eVar6.f7618h == null) {
                return;
            }
            eVar7 = this.f7649a.f7640g;
            for (l lVar7 : eVar7.f7618h) {
                if (lVar7 != null) {
                    lVar7.e();
                }
            }
        } else if (i16 == 50) {
            eVar3 = this.f7649a.f7640g;
            if (eVar3.f7618h == null) {
                return;
            }
            eVar4 = this.f7649a.f7640g;
            for (l lVar8 : eVar4.f7618h) {
                if (lVar8 != null) {
                    int i21 = message.arg1;
                    if (i21 != 0) {
                        if (i21 == 1) {
                            eVar5 = this.f7649a.f7640g;
                            if (eVar5.E().f7569a >= 18.0f) {
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
