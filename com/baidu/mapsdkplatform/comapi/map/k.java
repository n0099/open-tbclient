package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class k extends Handler {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:20:0x0098 */
    /* JADX WARN: Incorrect condition in loop: B:23:0x00a1 */
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
        eVar = this.a.g;
        if (eVar == null) {
            return;
        }
        long longValue = ((Long) message.obj).longValue();
        eVar2 = this.a.g;
        if (longValue == eVar2.j) {
            if (message.what == 4000) {
                eVar31 = this.a.g;
                if (eVar31.h != null) {
                    eVar32 = this.a.g;
                    for (l lVar : eVar32.h) {
                        Bitmap bitmap = null;
                        if (message.arg2 == 1) {
                            i3 = this.a.d;
                            i4 = this.a.e;
                            int[] iArr = new int[i3 * i4];
                            i5 = this.a.d;
                            i6 = this.a.e;
                            int[] iArr2 = new int[i5 * i6];
                            eVar33 = this.a.g;
                            if (eVar33.i == null) {
                                return;
                            }
                            eVar34 = this.a.g;
                            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = eVar34.i;
                            i7 = this.a.d;
                            i8 = this.a.e;
                            int[] a = aVar.a(iArr, i7, i8);
                            for (int i16 = 0; i16 < i9; i16++) {
                                for (int i17 = 0; i17 < i12; i17++) {
                                    i13 = this.a.d;
                                    int i18 = a[(i13 * i16) + i17];
                                    i14 = this.a.e;
                                    i15 = this.a.d;
                                    iArr2[(((i14 - i16) - 1) * i15) + i17] = (i18 & (-16711936)) | ((i18 << 16) & 16711680) | ((i18 >> 16) & 255);
                                }
                            }
                            i10 = this.a.d;
                            i11 = this.a.e;
                            bitmap = Bitmap.createBitmap(iArr2, i10, i11, Bitmap.Config.RGB_565);
                        }
                        if (lVar != null) {
                            lVar.a(bitmap);
                        }
                    }
                }
            } else if (message.what == 39) {
                eVar16 = this.a.g;
                if (eVar16 != null) {
                    eVar17 = this.a.g;
                    if (eVar17.h != null) {
                        if (message.arg1 == 100) {
                            eVar30 = this.a.g;
                            eVar30.B();
                        } else if (message.arg1 == 200) {
                            eVar21 = this.a.g;
                            eVar21.K();
                        } else if (message.arg1 == 1) {
                            this.a.requestRender();
                        } else if (message.arg1 == 0) {
                            this.a.requestRender();
                            eVar20 = this.a.g;
                            if (!eVar20.b() && this.a.getRenderMode() != 0) {
                                this.a.setRenderMode(0);
                            }
                        } else if (message.arg1 == 2) {
                            eVar18 = this.a.g;
                            if (eVar18.h == null) {
                                return;
                            }
                            eVar19 = this.a.g;
                            for (l lVar2 : eVar19.h) {
                                if (lVar2 != null) {
                                    lVar2.c();
                                }
                            }
                        }
                        eVar22 = this.a.g;
                        if (!eVar22.k) {
                            i = this.a.e;
                            if (i > 0) {
                                i2 = this.a.d;
                                if (i2 > 0) {
                                    eVar27 = this.a.g;
                                    if (eVar27.b(0, 0) != null) {
                                        eVar28 = this.a.g;
                                        eVar28.k = true;
                                        eVar29 = this.a.g;
                                        for (l lVar3 : eVar29.h) {
                                            if (lVar3 != null) {
                                                lVar3.b();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        eVar23 = this.a.g;
                        for (l lVar4 : eVar23.h) {
                            if (lVar4 != null) {
                                lVar4.a();
                            }
                        }
                        eVar24 = this.a.g;
                        if (eVar24.q()) {
                            eVar25 = this.a.g;
                            for (l lVar5 : eVar25.h) {
                                eVar26 = this.a.g;
                                if (eVar26.E().a >= 18.0f) {
                                    if (lVar5 != null) {
                                        lVar5.a(true);
                                    }
                                } else if (lVar5 != null) {
                                    lVar5.a(false);
                                }
                            }
                        }
                    }
                }
            } else if (message.what == 41) {
                eVar8 = this.a.g;
                if (eVar8 != null) {
                    eVar9 = this.a.g;
                    if (eVar9.h != null) {
                        eVar10 = this.a.g;
                        if (!eVar10.n) {
                            eVar15 = this.a.g;
                            if (!eVar15.o) {
                                return;
                            }
                        }
                        eVar11 = this.a.g;
                        for (l lVar6 : eVar11.h) {
                            if (lVar6 != null) {
                                eVar12 = this.a.g;
                                lVar6.b(eVar12.E());
                                eVar13 = this.a.g;
                                if (eVar13.q()) {
                                    eVar14 = this.a.g;
                                    if (eVar14.E().a >= 18.0f) {
                                        lVar6.a(true);
                                    } else {
                                        lVar6.a(false);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (message.what == 999) {
                eVar6 = this.a.g;
                if (eVar6.h != null) {
                    eVar7 = this.a.g;
                    for (l lVar7 : eVar7.h) {
                        if (lVar7 != null) {
                            lVar7.e();
                        }
                    }
                }
            } else if (message.what == 50) {
                eVar3 = this.a.g;
                if (eVar3.h != null) {
                    eVar4 = this.a.g;
                    for (l lVar8 : eVar4.h) {
                        if (lVar8 != null) {
                            if (message.arg1 == 0) {
                                lVar8.a(false);
                            } else if (message.arg1 == 1) {
                                eVar5 = this.a.g;
                                if (eVar5.E().a >= 18.0f) {
                                    lVar8.a(true);
                                } else {
                                    lVar8.a(false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
