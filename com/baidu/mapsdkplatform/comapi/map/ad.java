package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import androidx.recyclerview.widget.ItemTouchHelper;
/* loaded from: classes2.dex */
public class ad extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ac f7598a;

    public ad(ac acVar) {
        this.f7598a = acVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fb, code lost:
        if (r13 != null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fd, code lost:
        r13 = r12.f7598a.f7596h;
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
        eVar = this.f7598a.f7597i;
        if (eVar != null) {
            eVar2 = this.f7598a.f7597i;
            if (eVar2.f7625i == null) {
                return;
            }
            long longValue = ((Long) message.obj).longValue();
            eVar3 = this.f7598a.f7597i;
            if (longValue != eVar3.j) {
                return;
            }
            int i2 = message.what;
            if (i2 == 4000) {
                eVar33 = this.f7598a.f7597i;
                if (eVar33.f7624h == null) {
                    return;
                }
                eVar34 = this.f7598a.f7597i;
                for (l lVar : eVar34.f7624h) {
                    Bitmap bitmap = null;
                    if (message.arg2 == 1) {
                        int[] iArr = new int[ac.f7589a * ac.f7590b];
                        int[] iArr2 = new int[ac.f7589a * ac.f7590b];
                        eVar35 = this.f7598a.f7597i;
                        if (eVar35.f7625i == null) {
                            return;
                        }
                        eVar36 = this.f7598a.f7597i;
                        int[] a2 = eVar36.f7625i.a(iArr, ac.f7589a, ac.f7590b);
                        for (int i3 = 0; i3 < ac.f7590b; i3++) {
                            int i4 = 0;
                            while (true) {
                                int i5 = ac.f7589a;
                                if (i4 < i5) {
                                    int i6 = a2[(i5 * i3) + i4];
                                    iArr2[(((ac.f7590b - i3) - 1) * ac.f7589a) + i4] = (i6 & (-16711936)) | ((i6 << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((i6 >> 16) & 255);
                                    i4++;
                                }
                            }
                        }
                        bitmap = Bitmap.createBitmap(iArr2, ac.f7589a, ac.f7590b, Bitmap.Config.ARGB_8888);
                    }
                    if (lVar != null) {
                        lVar.a(bitmap);
                    }
                }
            } else if (i2 == 39) {
                eVar17 = this.f7598a.f7597i;
                if (eVar17 == null) {
                    return;
                }
                int i7 = message.arg1;
                if (i7 == 100) {
                    eVar32 = this.f7598a.f7597i;
                    eVar32.B();
                } else if (i7 == 200) {
                    eVar20 = this.f7598a.f7597i;
                    eVar20.L();
                } else if (i7 == 1) {
                    mVar2 = this.f7598a.f7596h;
                } else if (i7 == 0) {
                    mVar = this.f7598a.f7596h;
                } else if (i7 == 2) {
                    eVar18 = this.f7598a.f7597i;
                    if (eVar18.f7624h == null) {
                        return;
                    }
                    eVar19 = this.f7598a.f7597i;
                    for (l lVar2 : eVar19.f7624h) {
                        if (lVar2 != null) {
                            lVar2.c();
                        }
                    }
                }
                eVar21 = this.f7598a.f7597i;
                if (!eVar21.k && ac.f7590b > 0 && ac.f7589a > 0) {
                    eVar28 = this.f7598a.f7597i;
                    if (eVar28.b(0, 0) != null) {
                        eVar29 = this.f7598a.f7597i;
                        eVar29.k = true;
                        eVar30 = this.f7598a.f7597i;
                        if (eVar30.f7624h == null) {
                            return;
                        }
                        eVar31 = this.f7598a.f7597i;
                        for (l lVar3 : eVar31.f7624h) {
                            if (lVar3 != null) {
                                lVar3.b();
                            }
                        }
                    }
                }
                eVar22 = this.f7598a.f7597i;
                if (eVar22.f7624h == null) {
                    return;
                }
                eVar23 = this.f7598a.f7597i;
                for (l lVar4 : eVar23.f7624h) {
                    if (lVar4 != null) {
                        lVar4.a();
                    }
                }
                eVar24 = this.f7598a.f7597i;
                if (eVar24.q()) {
                    eVar25 = this.f7598a.f7597i;
                    if (eVar25.f7624h == null) {
                        return;
                    }
                    eVar26 = this.f7598a.f7597i;
                    for (l lVar5 : eVar26.f7624h) {
                        if (lVar5 != null) {
                            eVar27 = this.f7598a.f7597i;
                            if (eVar27.E().f7571a >= 18.0f) {
                                lVar5.a(true);
                            } else {
                                lVar5.a(false);
                            }
                        }
                    }
                }
            } else if (i2 == 41) {
                eVar9 = this.f7598a.f7597i;
                if (eVar9 == null) {
                    return;
                }
                eVar10 = this.f7598a.f7597i;
                if (!eVar10.n) {
                    eVar16 = this.f7598a.f7597i;
                    if (!eVar16.o) {
                        return;
                    }
                }
                eVar11 = this.f7598a.f7597i;
                if (eVar11.f7624h == null) {
                    return;
                }
                eVar12 = this.f7598a.f7597i;
                for (l lVar6 : eVar12.f7624h) {
                    if (lVar6 != null) {
                        eVar13 = this.f7598a.f7597i;
                        lVar6.b(eVar13.E());
                        eVar14 = this.f7598a.f7597i;
                        if (eVar14.q()) {
                            eVar15 = this.f7598a.f7597i;
                            if (eVar15.E().f7571a >= 18.0f) {
                                lVar6.a(true);
                            } else {
                                lVar6.a(false);
                            }
                        }
                    }
                }
            } else if (i2 == 999) {
                eVar7 = this.f7598a.f7597i;
                if (eVar7.f7624h == null) {
                    return;
                }
                eVar8 = this.f7598a.f7597i;
                for (l lVar7 : eVar8.f7624h) {
                    if (lVar7 != null) {
                        lVar7.e();
                    }
                }
            } else if (i2 == 50) {
                eVar4 = this.f7598a.f7597i;
                if (eVar4.f7624h == null) {
                    return;
                }
                eVar5 = this.f7598a.f7597i;
                for (l lVar8 : eVar5.f7624h) {
                    if (lVar8 != null) {
                        int i8 = message.arg1;
                        if (i8 != 0) {
                            if (i8 == 1) {
                                eVar6 = this.f7598a.f7597i;
                                if (eVar6.E().f7571a >= 18.0f) {
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
