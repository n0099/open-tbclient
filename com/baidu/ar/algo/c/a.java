package com.baidu.ar.algo.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private int d = 10;
    List<Integer> a = new ArrayList();
    Integer[] b = new Integer[this.d];
    Comparator<Integer> c = new Comparator<Integer>() { // from class: com.baidu.ar.algo.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Integer num, Integer num2) {
            if (num.intValue() > num.intValue()) {
                return 1;
            }
            return num.intValue() < num.intValue() ? -1 : 0;
        }
    };

    private int a(Integer[] numArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += numArr[i3].intValue();
        }
        return i2;
    }

    private int b() {
        int size = this.a.size();
        if (size <= this.d) {
            if (size == 1) {
                return this.a.get(0).intValue();
            }
            if (size != 0) {
                if (size == 2) {
                    return (int) (((this.a.get(1).intValue() + this.a.get(0).intValue()) * 1.0f) / 2.0f);
                }
                if (this.b.length != this.d) {
                    this.b = new Integer[this.d];
                }
                System.arraycopy(this.a.toArray(), 0, this.b, 0, size);
                Arrays.sort(this.b, 0, size, this.c);
                int intValue = this.b[0].intValue();
                return (int) ((((a(this.b, size) - intValue) - this.b[size - 1].intValue()) * 1.0f) / (size - 2));
            }
            return 0;
        }
        return 0;
    }

    private void b(int i) {
        if (this.a.size() < this.d) {
            this.a.add(Integer.valueOf(i));
            return;
        }
        this.a.remove(0);
        this.a.add(Integer.valueOf(i));
    }

    public int a(int i) {
        b(i);
        return b();
    }

    public void a() {
        this.a.clear();
        this.b = null;
    }
}
