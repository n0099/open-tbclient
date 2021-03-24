package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import java.util.Locale;
/* loaded from: classes.dex */
public final class LocaleListCompat {
    public static final LocaleListInterface IMPL;
    public static final LocaleListCompat sEmptyLocaleList = new LocaleListCompat();

    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class LocaleListCompatApi24Impl implements LocaleListInterface {
        public LocaleList mLocaleList = new LocaleList(new Locale[0]);

        @Override // androidx.core.os.LocaleListInterface
        public boolean equals(Object obj) {
            return this.mLocaleList.equals(((LocaleListCompat) obj).unwrap());
        }

        @Override // androidx.core.os.LocaleListInterface
        public Locale get(int i) {
            return this.mLocaleList.get(i);
        }

        @Override // androidx.core.os.LocaleListInterface
        @Nullable
        public Locale getFirstMatch(String[] strArr) {
            LocaleList localeList = this.mLocaleList;
            if (localeList != null) {
                return localeList.getFirstMatch(strArr);
            }
            return null;
        }

        @Override // androidx.core.os.LocaleListInterface
        public Object getLocaleList() {
            return this.mLocaleList;
        }

        @Override // androidx.core.os.LocaleListInterface
        public int hashCode() {
            return this.mLocaleList.hashCode();
        }

        @Override // androidx.core.os.LocaleListInterface
        @IntRange(from = -1)
        public int indexOf(Locale locale) {
            return this.mLocaleList.indexOf(locale);
        }

        @Override // androidx.core.os.LocaleListInterface
        public boolean isEmpty() {
            return this.mLocaleList.isEmpty();
        }

        @Override // androidx.core.os.LocaleListInterface
        public void setLocaleList(@NonNull Locale... localeArr) {
            this.mLocaleList = new LocaleList(localeArr);
        }

        @Override // androidx.core.os.LocaleListInterface
        @IntRange(from = 0)
        public int size() {
            return this.mLocaleList.size();
        }

        @Override // androidx.core.os.LocaleListInterface
        public String toLanguageTags() {
            return this.mLocaleList.toLanguageTags();
        }

        @Override // androidx.core.os.LocaleListInterface
        public String toString() {
            return this.mLocaleList.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class LocaleListCompatBaseImpl implements LocaleListInterface {
        public LocaleListHelper mLocaleList = new LocaleListHelper(new Locale[0]);

        @Override // androidx.core.os.LocaleListInterface
        public boolean equals(Object obj) {
            return this.mLocaleList.equals(((LocaleListCompat) obj).unwrap());
        }

        @Override // androidx.core.os.LocaleListInterface
        public Locale get(int i) {
            return this.mLocaleList.get(i);
        }

        @Override // androidx.core.os.LocaleListInterface
        @Nullable
        public Locale getFirstMatch(String[] strArr) {
            LocaleListHelper localeListHelper = this.mLocaleList;
            if (localeListHelper != null) {
                return localeListHelper.getFirstMatch(strArr);
            }
            return null;
        }

        @Override // androidx.core.os.LocaleListInterface
        public Object getLocaleList() {
            return this.mLocaleList;
        }

        @Override // androidx.core.os.LocaleListInterface
        public int hashCode() {
            return this.mLocaleList.hashCode();
        }

        @Override // androidx.core.os.LocaleListInterface
        @IntRange(from = -1)
        public int indexOf(Locale locale) {
            return this.mLocaleList.indexOf(locale);
        }

        @Override // androidx.core.os.LocaleListInterface
        public boolean isEmpty() {
            return this.mLocaleList.isEmpty();
        }

        @Override // androidx.core.os.LocaleListInterface
        public void setLocaleList(@NonNull Locale... localeArr) {
            this.mLocaleList = new LocaleListHelper(localeArr);
        }

        @Override // androidx.core.os.LocaleListInterface
        @IntRange(from = 0)
        public int size() {
            return this.mLocaleList.size();
        }

        @Override // androidx.core.os.LocaleListInterface
        public String toLanguageTags() {
            return this.mLocaleList.toLanguageTags();
        }

        @Override // androidx.core.os.LocaleListInterface
        public String toString() {
            return this.mLocaleList.toString();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            IMPL = new LocaleListCompatApi24Impl();
        } else {
            IMPL = new LocaleListCompatBaseImpl();
        }
    }

    public static LocaleListCompat create(@NonNull Locale... localeArr) {
        LocaleListCompat localeListCompat = new LocaleListCompat();
        localeListCompat.setLocaleListArray(localeArr);
        return localeListCompat;
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String str) {
        Locale forLanguageTag;
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",", -1);
            int length = split.length;
            Locale[] localeArr = new Locale[length];
            for (int i = 0; i < length; i++) {
                if (Build.VERSION.SDK_INT >= 21) {
                    forLanguageTag = Locale.forLanguageTag(split[i]);
                } else {
                    forLanguageTag = LocaleHelper.forLanguageTag(split[i]);
                }
                localeArr[i] = forLanguageTag;
            }
            LocaleListCompat localeListCompat = new LocaleListCompat();
            localeListCompat.setLocaleListArray(localeArr);
            return localeListCompat;
        }
        return getEmptyLocaleList();
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getAdjustedDefault() {
        return Build.VERSION.SDK_INT >= 24 ? wrap(LocaleList.getAdjustedDefault()) : create(Locale.getDefault());
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getDefault() {
        return Build.VERSION.SDK_INT >= 24 ? wrap(LocaleList.getDefault()) : create(Locale.getDefault());
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @RequiresApi(24)
    private void setLocaleList(LocaleList localeList) {
        int size = localeList.size();
        if (size > 0) {
            Locale[] localeArr = new Locale[size];
            for (int i = 0; i < size; i++) {
                localeArr[i] = localeList.get(i);
            }
            IMPL.setLocaleList(localeArr);
        }
    }

    private void setLocaleListArray(Locale... localeArr) {
        IMPL.setLocaleList(localeArr);
    }

    @RequiresApi(24)
    public static LocaleListCompat wrap(Object obj) {
        LocaleListCompat localeListCompat = new LocaleListCompat();
        if (obj instanceof LocaleList) {
            localeListCompat.setLocaleList((LocaleList) obj);
        }
        return localeListCompat;
    }

    public boolean equals(Object obj) {
        return IMPL.equals(obj);
    }

    public Locale get(int i) {
        return IMPL.get(i);
    }

    public Locale getFirstMatch(String[] strArr) {
        return IMPL.getFirstMatch(strArr);
    }

    public int hashCode() {
        return IMPL.hashCode();
    }

    @IntRange(from = -1)
    public int indexOf(Locale locale) {
        return IMPL.indexOf(locale);
    }

    public boolean isEmpty() {
        return IMPL.isEmpty();
    }

    @IntRange(from = 0)
    public int size() {
        return IMPL.size();
    }

    @NonNull
    public String toLanguageTags() {
        return IMPL.toLanguageTags();
    }

    public String toString() {
        return IMPL.toString();
    }

    @Nullable
    public Object unwrap() {
        return IMPL.getLocaleList();
    }
}
