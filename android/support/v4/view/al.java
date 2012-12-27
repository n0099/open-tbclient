package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.view.ViewPager;
/* loaded from: classes.dex */
final class al implements android.support.v4.a.c {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.a.c
    /* renamed from: b */
    public ViewPager.SavedState a(Parcel parcel, ClassLoader classLoader) {
        return new ViewPager.SavedState(parcel, classLoader);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.a.c
    /* renamed from: b */
    public ViewPager.SavedState[] a(int i) {
        return new ViewPager.SavedState[i];
    }
}
