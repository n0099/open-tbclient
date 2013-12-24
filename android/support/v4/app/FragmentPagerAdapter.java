package android.support.v4.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class FragmentPagerAdapter extends android.support.v4.view.ae {
    private final t a;
    private ae b = null;
    private Fragment c = null;

    public abstract Fragment a(int i);

    public FragmentPagerAdapter(t tVar) {
        this.a = tVar;
    }

    @Override // android.support.v4.view.ae
    public void startUpdate(ViewGroup viewGroup) {
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.b == null) {
            this.b = this.a.a();
        }
        long b = b(i);
        Fragment a = this.a.a(a(viewGroup.getId(), b));
        if (a != null) {
            this.b.e(a);
        } else {
            a = a(i);
            this.b.a(viewGroup.getId(), a, a(viewGroup.getId(), b));
        }
        if (a != this.c) {
            a.c(false);
            a.d(false);
        }
        return a;
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.b == null) {
            this.b = this.a.a();
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
            this.a.b();
        }
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).q() == view;
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
