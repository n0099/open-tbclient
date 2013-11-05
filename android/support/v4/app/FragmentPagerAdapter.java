package android.support.v4.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class FragmentPagerAdapter extends android.support.v4.view.ae {

    /* renamed from: a  reason: collision with root package name */
    private final t f278a;
    private ae b = null;
    private Fragment c = null;

    public abstract Fragment a(int i);

    public FragmentPagerAdapter(t tVar) {
        this.f278a = tVar;
    }

    @Override // android.support.v4.view.ae
    public void startUpdate(ViewGroup viewGroup) {
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.b == null) {
            this.b = this.f278a.a();
        }
        long b = b(i);
        Fragment a2 = this.f278a.a(a(viewGroup.getId(), b));
        if (a2 != null) {
            this.b.e(a2);
        } else {
            a2 = a(i);
            this.b.a(viewGroup.getId(), a2, a(viewGroup.getId(), b));
        }
        if (a2 != this.c) {
            a2.c(false);
            a2.d(false);
        }
        return a2;
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.b == null) {
            this.b = this.f278a.a();
        }
        this.b.d((Fragment) obj);
    }

    @Override // android.support.v4.view.ae
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.c) {
            if (this.c != null) {
                this.c.c(false);
                this.c.d(false);
            }
            if (fragment != null) {
                fragment.c(true);
                fragment.d(true);
            }
            this.c = fragment;
        }
    }

    @Override // android.support.v4.view.ae
    public void finishUpdate(ViewGroup viewGroup) {
        if (this.b != null) {
            this.b.b();
            this.b = null;
            this.f278a.b();
        }
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).o() == view;
    }

    @Override // android.support.v4.view.ae
    public Parcelable saveState() {
        return null;
    }

    @Override // android.support.v4.view.ae
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public long b(int i) {
        return i;
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
