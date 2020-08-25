package com.alibaba.fastjson.serializer;

import java.util.Arrays;
/* loaded from: classes11.dex */
public class Labels {

    /* loaded from: classes11.dex */
    private static class DefaultLabelFilter implements LabelFilter {
        private String[] excludes;
        private String[] includes;

        public DefaultLabelFilter(String[] strArr, String[] strArr2) {
            if (strArr != null) {
                this.includes = new String[strArr.length];
                System.arraycopy(strArr, 0, this.includes, 0, strArr.length);
                Arrays.sort(this.includes);
            }
            if (strArr2 != null) {
                this.excludes = new String[strArr2.length];
                System.arraycopy(strArr2, 0, this.excludes, 0, strArr2.length);
                Arrays.sort(this.excludes);
            }
        }

        @Override // com.alibaba.fastjson.serializer.LabelFilter
        public boolean apply(String str) {
            return this.excludes != null ? Arrays.binarySearch(this.excludes, str) == -1 : this.includes != null && Arrays.binarySearch(this.includes, str) >= 0;
        }
    }

    public static LabelFilter includes(String... strArr) {
        return new DefaultLabelFilter(strArr, null);
    }

    public static LabelFilter excludes(String... strArr) {
        return new DefaultLabelFilter(null, strArr);
    }
}
