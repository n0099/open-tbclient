package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.protobuf.CodedOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends a {
    final /* synthetic */ ViewPager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(ViewPager viewPager) {
        this.b = viewPager;
    }

    @Override // android.support.v4.view.a
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001f, code lost:
        if (r1.getCount() > 1) goto L5;
     */
    @Override // android.support.v4.view.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(View view, android.support.v4.view.a.a aVar) {
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        int i;
        int i2;
        ae aeVar4;
        int i3;
        int i4;
        ae aeVar5;
        ae aeVar6;
        boolean z = true;
        super.a(view, aVar);
        aVar.a(ViewPager.class.getName());
        aeVar = this.b.h;
        if (aeVar != null) {
            aeVar6 = this.b.h;
        }
        z = false;
        aVar.a(z);
        aeVar2 = this.b.h;
        if (aeVar2 != null) {
            i3 = this.b.i;
            if (i3 >= 0) {
                i4 = this.b.i;
                aeVar5 = this.b.h;
                if (i4 < aeVar5.getCount() - 1) {
                    aVar.a(CodedOutputStream.DEFAULT_BUFFER_SIZE);
                }
            }
        }
        aeVar3 = this.b.h;
        if (aeVar3 != null) {
            i = this.b.i;
            if (i > 0) {
                i2 = this.b.i;
                aeVar4 = this.b.h;
                if (i2 < aeVar4.getCount()) {
                    aVar.a(8192);
                }
            }
        }
    }

    @Override // android.support.v4.view.a
    public boolean a(View view, int i, Bundle bundle) {
        ae aeVar;
        int i2;
        int i3;
        ae aeVar2;
        int i4;
        ae aeVar3;
        int i5;
        int i6;
        ae aeVar4;
        int i7;
        if (super.a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case CodedOutputStream.DEFAULT_BUFFER_SIZE /* 4096 */:
                aeVar3 = this.b.h;
                if (aeVar3 != null) {
                    i5 = this.b.i;
                    if (i5 >= 0) {
                        i6 = this.b.i;
                        aeVar4 = this.b.h;
                        if (i6 < aeVar4.getCount() - 1) {
                            ViewPager viewPager = this.b;
                            i7 = this.b.i;
                            viewPager.setCurrentItem(i7 + 1);
                            return true;
                        }
                    }
                }
                return false;
            case 8192:
                aeVar = this.b.h;
                if (aeVar != null) {
                    i2 = this.b.i;
                    if (i2 > 0) {
                        i3 = this.b.i;
                        aeVar2 = this.b.h;
                        if (i3 < aeVar2.getCount()) {
                            ViewPager viewPager2 = this.b;
                            i4 = this.b.i;
                            viewPager2.setCurrentItem(i4 - 1);
                            return true;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
