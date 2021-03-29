package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import androidx.recyclerview.widget.ItemTouchHelper;
/* loaded from: classes2.dex */
public class ad extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ac f7594a;

    public ad(ac acVar) {
        this.f7594a = acVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fb, code lost:
        if (r13 != null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fd, code lost:
        r13 = r12.f7594a.f7593h;
        r13.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010f, code lost:
        if (r13 != null) goto L116;
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
        super.handleMessage(message);
        eVar = this.f7594a.i;
        if (eVar != null) {
            eVar2 = this.f7594a.i;
            if (eVar2.i == null) {
                return;
            }
            long longValue = ((Long) message.obj).longValue();
            eVar3 = this.f7594a.i;
            if (longValue != eVar3.j) {
                return;
            }
            int i = message.what;
            if (i == 4000) {
                eVar33 = this.f7594a.i;
                if (eVar33.f7619h == null) {
                    return;
                }
                eVar34 = this.f7594a.i;
                for (l lVar : eVar34.f7619h) {
                    Bitmap bitmap = null;
                    if (message.arg2 == 1) {
                        int[] iArr = new int[ac.f7586a * ac.f7587b];
                        int[] iArr2 = new int[ac.f7586a * ac.f7587b];
                        eVar35 = this.f7594a.i;
                        if (eVar35.i == null) {
                            return;
                        }
                        eVar36 = this.f7594a.i;
                        int[] a2 = eVar36.i.a(iArr, ac.f7586a, ac.f7587b);
                        for (int i2 = 0; i2 < ac.f7587b; i2++) {
                            int i3 = 0;
                            while (true) {
                                int i4 = ac.f7586a;
                                if (i3 < i4) {
                                    int i5 = a2[(i4 * i2) + i3];
                                    iArr2[(((ac.f7587b - i2) - 1) * ac.f7586a) + i3] = (i5 & (-16711936)) | ((i5 << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((i5 >> 16) & 255);
                                    i3++;
                                }
                            }
                        }
                        bitmap = Bitmap.createBitmap(iArr2, ac.f7586a, ac.f7587b, Bitmap.Config.ARGB_8888);
                    }
                    if (lVar != null) {
                        lVar.a(bitmap);
                    }
                }
            } else if (i == 39) {
                eVar17 = this.f7594a.i;
                if (eVar17 == null) {
                    return;
                }
                int i6 = message.arg1;
                if (i6 == 100) {
                    eVar32 = this.f7594a.i;
                    eVar32.B();
                } else if (i6 == 200) {
                    eVar20 = this.f7594a.i;
                    eVar20.K();
                } else if (i6 == 1) {
                    mVar2 = this.f7594a.f7593h;
                } else if (i6 == 0) {
                    mVar = this.f7594a.f7593h;
                } else if (i6 == 2) {
                    eVar18 = this.f7594a.i;
                    if (eVar18.f7619h == null) {
                        return;
                    }
                    eVar19 = this.f7594a.i;
                    for (l lVar2 : eVar19.f7619h) {
                        if (lVar2 != null) {
                            lVar2.c();
                        }
                    }
                }
                eVar21 = this.f7594a.i;
                if (!eVar21.k && ac.f7587b > 0 && ac.f7586a > 0) {
                    eVar28 = this.f7594a.i;
                    if (eVar28.b(0, 0) != null) {
                        eVar29 = this.f7594a.i;
                        eVar29.k = true;
                        eVar30 = this.f7594a.i;
                        if (eVar30.f7619h == null) {
                            return;
                        }
                        eVar31 = this.f7594a.i;
                        for (l lVar3 : eVar31.f7619h) {
                            if (lVar3 != null) {
                                lVar3.b();
                            }
                        }
                    }
                }
                eVar22 = this.f7594a.i;
                if (eVar22.f7619h == null) {
                    return;
                }
                eVar23 = this.f7594a.i;
                for (l lVar4 : eVar23.f7619h) {
                    if (lVar4 != null) {
                        lVar4.a();
                    }
                }
                eVar24 = this.f7594a.i;
                if (eVar24.q()) {
                    eVar25 = this.f7594a.i;
                    if (eVar25.f7619h == null) {
                        return;
                    }
                    eVar26 = this.f7594a.i;
                    for (l lVar5 : eVar26.f7619h) {
                        if (lVar5 != null) {
                            eVar27 = this.f7594a.i;
                            if (eVar27.E().f7570a >= 18.0f) {
                                lVar5.a(true);
                            } else {
                                lVar5.a(false);
                            }
                        }
                    }
                }
            } else if (i == 41) {
                eVar9 = this.f7594a.i;
                if (eVar9 == null) {
                    return;
                }
                eVar10 = this.f7594a.i;
                if (!eVar10.n) {
                    eVar16 = this.f7594a.i;
                    if (!eVar16.o) {
                        return;
                    }
                }
                eVar11 = this.f7594a.i;
                if (eVar11.f7619h == null) {
                    return;
                }
                eVar12 = this.f7594a.i;
                for (l lVar6 : eVar12.f7619h) {
                    if (lVar6 != null) {
                        eVar13 = this.f7594a.i;
                        lVar6.b(eVar13.E());
                        eVar14 = this.f7594a.i;
                        if (eVar14.q()) {
                            eVar15 = this.f7594a.i;
                            if (eVar15.E().f7570a >= 18.0f) {
                                lVar6.a(true);
                            } else {
                                lVar6.a(false);
                            }
                        }
                    }
                }
            } else if (i == 999) {
                eVar7 = this.f7594a.i;
                if (eVar7.f7619h == null) {
                    return;
                }
                eVar8 = this.f7594a.i;
                for (l lVar7 : eVar8.f7619h) {
                    if (lVar7 != null) {
                        lVar7.e();
                    }
                }
            } else if (i == 50) {
                eVar4 = this.f7594a.i;
                if (eVar4.f7619h == null) {
                    return;
                }
                eVar5 = this.f7594a.i;
                for (l lVar8 : eVar5.f7619h) {
                    if (lVar8 != null) {
                        int i7 = message.arg1;
                        if (i7 != 0) {
                            if (i7 == 1) {
                                eVar6 = this.f7594a.i;
                                if (eVar6.E().f7570a >= 18.0f) {
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
