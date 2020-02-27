package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ad extends Handler {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // android.os.Handler
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
        m mVar3;
        m mVar4;
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
        super.handleMessage(message);
        eVar = this.a.i;
        if (eVar != null) {
            eVar2 = this.a.i;
            if (eVar2.i == null) {
                return;
            }
            long longValue = ((Long) message.obj).longValue();
            eVar3 = this.a.i;
            if (longValue == eVar3.j) {
                if (message.what == 4000) {
                    eVar33 = this.a.i;
                    if (eVar33.h != null) {
                        eVar34 = this.a.i;
                        for (l lVar : eVar34.h) {
                            Bitmap bitmap = null;
                            if (message.arg2 == 1) {
                                int[] iArr = new int[ac.a * ac.b];
                                int[] iArr2 = new int[ac.a * ac.b];
                                eVar35 = this.a.i;
                                if (eVar35.i == null) {
                                    return;
                                }
                                eVar36 = this.a.i;
                                int[] a = eVar36.i.a(iArr, ac.a, ac.b);
                                for (int i = 0; i < ac.b; i++) {
                                    for (int i2 = 0; i2 < ac.a; i2++) {
                                        int i3 = a[(ac.a * i) + i2];
                                        iArr2[(((ac.b - i) - 1) * ac.a) + i2] = (i3 & (-16711936)) | ((i3 << 16) & 16711680) | ((i3 >> 16) & 255);
                                    }
                                }
                                bitmap = Bitmap.createBitmap(iArr2, ac.a, ac.b, Bitmap.Config.ARGB_8888);
                            }
                            if (lVar != null) {
                                lVar.a(bitmap);
                            }
                        }
                    }
                } else if (message.what == 39) {
                    eVar17 = this.a.i;
                    if (eVar17 != null) {
                        if (message.arg1 == 100) {
                            eVar32 = this.a.i;
                            eVar32.B();
                        } else if (message.arg1 == 200) {
                            eVar20 = this.a.i;
                            eVar20.K();
                        } else if (message.arg1 == 1) {
                            mVar3 = this.a.h;
                            if (mVar3 != null) {
                                mVar4 = this.a.h;
                                mVar4.a();
                            }
                        } else if (message.arg1 == 0) {
                            mVar = this.a.h;
                            if (mVar != null) {
                                mVar2 = this.a.h;
                                mVar2.a();
                            }
                        } else if (message.arg1 == 2) {
                            eVar18 = this.a.i;
                            if (eVar18.h == null) {
                                return;
                            }
                            eVar19 = this.a.i;
                            for (l lVar2 : eVar19.h) {
                                if (lVar2 != null) {
                                    lVar2.c();
                                }
                            }
                        }
                        eVar21 = this.a.i;
                        if (!eVar21.k && ac.b > 0 && ac.a > 0) {
                            eVar28 = this.a.i;
                            if (eVar28.b(0, 0) != null) {
                                eVar29 = this.a.i;
                                eVar29.k = true;
                                eVar30 = this.a.i;
                                if (eVar30.h == null) {
                                    return;
                                }
                                eVar31 = this.a.i;
                                for (l lVar3 : eVar31.h) {
                                    if (lVar3 != null) {
                                        lVar3.b();
                                    }
                                }
                            }
                        }
                        eVar22 = this.a.i;
                        if (eVar22.h != null) {
                            eVar23 = this.a.i;
                            for (l lVar4 : eVar23.h) {
                                if (lVar4 != null) {
                                    lVar4.a();
                                }
                            }
                            eVar24 = this.a.i;
                            if (eVar24.q()) {
                                eVar25 = this.a.i;
                                if (eVar25.h != null) {
                                    eVar26 = this.a.i;
                                    for (l lVar5 : eVar26.h) {
                                        if (lVar5 != null) {
                                            eVar27 = this.a.i;
                                            if (eVar27.E().a >= 18.0f) {
                                                lVar5.a(true);
                                            } else {
                                                lVar5.a(false);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (message.what == 41) {
                    eVar9 = this.a.i;
                    if (eVar9 != null) {
                        eVar10 = this.a.i;
                        if (!eVar10.n) {
                            eVar16 = this.a.i;
                            if (!eVar16.o) {
                                return;
                            }
                        }
                        eVar11 = this.a.i;
                        if (eVar11.h != null) {
                            eVar12 = this.a.i;
                            for (l lVar6 : eVar12.h) {
                                if (lVar6 != null) {
                                    eVar13 = this.a.i;
                                    lVar6.b(eVar13.E());
                                    eVar14 = this.a.i;
                                    if (eVar14.q()) {
                                        eVar15 = this.a.i;
                                        if (eVar15.E().a >= 18.0f) {
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
                    eVar7 = this.a.i;
                    if (eVar7.h != null) {
                        eVar8 = this.a.i;
                        for (l lVar7 : eVar8.h) {
                            if (lVar7 != null) {
                                lVar7.e();
                            }
                        }
                    }
                } else if (message.what == 50) {
                    eVar4 = this.a.i;
                    if (eVar4.h != null) {
                        eVar5 = this.a.i;
                        for (l lVar8 : eVar5.h) {
                            if (lVar8 != null) {
                                if (message.arg1 == 0) {
                                    lVar8.a(false);
                                } else if (message.arg1 == 1) {
                                    eVar6 = this.a.i;
                                    if (eVar6.E().a >= 18.0f) {
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
}
