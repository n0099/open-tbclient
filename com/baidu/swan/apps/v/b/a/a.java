package com.baidu.swan.apps.v.b.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public interface a {
    public static final b<Object> cho = new b<Object>() { // from class: com.baidu.swan.apps.v.b.a.a.1
        @Override // com.baidu.swan.apps.v.b.a.b
        protected Object a(Bundle bundle, String str, Object obj) {
            return bundle.get(str);
        }

        @Override // com.baidu.swan.apps.v.b.a.b
        protected void b(Bundle bundle, String str, Object obj) {
        }
    };
    public static final b<Boolean> chp = new b<Boolean>(false) { // from class: com.baidu.swan.apps.v.b.a.a.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Boolean a(Bundle bundle, String str, Boolean bool) {
            return Boolean.valueOf(bundle.getBoolean(str, bool.booleanValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    };
    public static final b<Byte> chq = new b<Byte>((byte) 0) { // from class: com.baidu.swan.apps.v.b.a.a.23
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Byte a(Bundle bundle, String str, Byte b) {
            return bundle.getByte(str, b.byteValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Byte b) {
            bundle.putByte(str, b.byteValue());
        }
    };
    public static final b<Short> chr = new b<Short>(0) { // from class: com.baidu.swan.apps.v.b.a.a.27
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Short a(Bundle bundle, String str, Short sh) {
            return Short.valueOf(bundle.getShort(str, sh.shortValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Short sh) {
            bundle.putShort(str, sh.shortValue());
        }
    };
    public static final b<Integer> chs = new b<Integer>(0) { // from class: com.baidu.swan.apps.v.b.a.a.28
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Integer a(Bundle bundle, String str, Integer num) {
            return Integer.valueOf(bundle.getInt(str, num.intValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    };
    public static final b<Long> cht = new b<Long>(0L) { // from class: com.baidu.swan.apps.v.b.a.a.29
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Long a(Bundle bundle, String str, Long l) {
            return Long.valueOf(bundle.getLong(str, l.longValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Long l) {
            bundle.putLong(str, l.longValue());
        }
    };
    public static final b<Float> chu = new b<Float>(Float.valueOf(0.0f)) { // from class: com.baidu.swan.apps.v.b.a.a.30
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Float a(Bundle bundle, String str, Float f) {
            return Float.valueOf(bundle.getFloat(str, f.floatValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Float f) {
            bundle.putFloat(str, f.floatValue());
        }
    };
    public static final b<Double> chv = new b<Double>(Double.valueOf(0.0d)) { // from class: com.baidu.swan.apps.v.b.a.a.31
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Double a(Bundle bundle, String str, Double d) {
            return Double.valueOf(bundle.getDouble(str, d.doubleValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Double d) {
            bundle.putDouble(str, d.doubleValue());
        }
    };
    public static final b<String> chw = new b<String>() { // from class: com.baidu.swan.apps.v.b.a.a.32
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public String a(Bundle bundle, String str, String str2) {
            return bundle.getString(str, str2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    };
    public static final b<CharSequence> chx = new b<CharSequence>() { // from class: com.baidu.swan.apps.v.b.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public CharSequence a(Bundle bundle, String str, CharSequence charSequence) {
            return bundle.getCharSequence(str, charSequence);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, CharSequence charSequence) {
            bundle.putCharSequence(str, charSequence);
        }
    };
    public static final b<Serializable> chy = new b<Serializable>() { // from class: com.baidu.swan.apps.v.b.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Serializable a(Bundle bundle, String str, Serializable serializable) {
            return bundle.getSerializable(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Serializable serializable) {
            bundle.putSerializable(str, serializable);
        }
    };
    public static final b<ArrayList<Integer>> chz = new b<ArrayList<Integer>>() { // from class: com.baidu.swan.apps.v.b.a.a.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public ArrayList<Integer> a(Bundle bundle, String str, ArrayList<Integer> arrayList) {
            return bundle.getIntegerArrayList(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, ArrayList<Integer> arrayList) {
            bundle.putIntegerArrayList(str, arrayList);
        }
    };
    public static final b<ArrayList<String>> chA = new b<ArrayList<String>>() { // from class: com.baidu.swan.apps.v.b.a.a.5
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public ArrayList<String> a(Bundle bundle, String str, ArrayList<String> arrayList) {
            return bundle.getStringArrayList(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, ArrayList<String> arrayList) {
            bundle.putStringArrayList(str, arrayList);
        }
    };
    public static final b<ArrayList<CharSequence>> chB = new b<ArrayList<CharSequence>>() { // from class: com.baidu.swan.apps.v.b.a.a.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public ArrayList<CharSequence> a(Bundle bundle, String str, ArrayList<CharSequence> arrayList) {
            return bundle.getCharSequenceArrayList(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, ArrayList<CharSequence> arrayList) {
            bundle.putCharSequenceArrayList(str, arrayList);
        }
    };
    public static final b<boolean[]> chC = new b<boolean[]>() { // from class: com.baidu.swan.apps.v.b.a.a.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public boolean[] a(Bundle bundle, String str, boolean[] zArr) {
            return bundle.getBooleanArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    };
    public static final b<byte[]> chD = new b<byte[]>() { // from class: com.baidu.swan.apps.v.b.a.a.8
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public byte[] a(Bundle bundle, String str, byte[] bArr) {
            return bundle.getByteArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, byte[] bArr) {
            bundle.putByteArray(str, bArr);
        }
    };
    public static final b<short[]> chE = new b<short[]>() { // from class: com.baidu.swan.apps.v.b.a.a.9
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public short[] a(Bundle bundle, String str, short[] sArr) {
            return bundle.getShortArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, short[] sArr) {
            bundle.putShortArray(str, sArr);
        }
    };
    public static final b<char[]> chF = new b<char[]>() { // from class: com.baidu.swan.apps.v.b.a.a.10
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public char[] a(Bundle bundle, String str, char[] cArr) {
            return bundle.getCharArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, char[] cArr) {
            bundle.putCharArray(str, cArr);
        }
    };
    public static final b<int[]> chG = new b<int[]>() { // from class: com.baidu.swan.apps.v.b.a.a.11
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public int[] a(Bundle bundle, String str, int[] iArr) {
            return bundle.getIntArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    };
    public static final b<long[]> chH = new b<long[]>() { // from class: com.baidu.swan.apps.v.b.a.a.13
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public long[] a(Bundle bundle, String str, long[] jArr) {
            return bundle.getLongArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    };
    public static final b<float[]> chI = new b<float[]>() { // from class: com.baidu.swan.apps.v.b.a.a.14
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public float[] a(Bundle bundle, String str, float[] fArr) {
            return bundle.getFloatArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    };
    public static final b<double[]> chJ = new b<double[]>() { // from class: com.baidu.swan.apps.v.b.a.a.15
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public double[] a(Bundle bundle, String str, double[] dArr) {
            return bundle.getDoubleArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, double[] dArr) {
            bundle.putDoubleArray(str, dArr);
        }
    };
    public static final b<String[]> chK = new b<String[]>() { // from class: com.baidu.swan.apps.v.b.a.a.16
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public String[] a(Bundle bundle, String str, String[] strArr) {
            return bundle.getStringArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    };
    public static final b<CharSequence[]> chL = new b<CharSequence[]>() { // from class: com.baidu.swan.apps.v.b.a.a.17
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public CharSequence[] a(Bundle bundle, String str, CharSequence[] charSequenceArr) {
            return bundle.getCharSequenceArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, CharSequence[] charSequenceArr) {
            bundle.putCharSequenceArray(str, charSequenceArr);
        }
    };
    @RequiresApi(api = 21)
    public static final b<Size> chM = new b<Size>() { // from class: com.baidu.swan.apps.v.b.a.a.18
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Size a(Bundle bundle, String str, Size size) {
            return bundle.getSize(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Size size) {
            bundle.putSize(str, size);
        }
    };
    @RequiresApi(api = 21)
    public static final b<SizeF> chN = new b<SizeF>() { // from class: com.baidu.swan.apps.v.b.a.a.19
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public SizeF a(Bundle bundle, String str, SizeF sizeF) {
            return bundle.getSizeF(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, SizeF sizeF) {
            bundle.putSizeF(str, sizeF);
        }
    };
    public static final b<Bundle> chO = new b<Bundle>() { // from class: com.baidu.swan.apps.v.b.a.a.20
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Bundle a(Bundle bundle, String str, Bundle bundle2) {
            return bundle.getBundle(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Bundle bundle2) {
            bundle.putBundle(str, bundle2);
        }
    };
    public static final b<Parcelable> chP = new b<Parcelable>() { // from class: com.baidu.swan.apps.v.b.a.a.21
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Parcelable a(Bundle bundle, String str, Parcelable parcelable) {
            return bundle.getParcelable(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Parcelable parcelable) {
            bundle.putParcelable(str, parcelable);
        }
    };
    public static final b<Parcelable[]> chQ = new b<Parcelable[]>() { // from class: com.baidu.swan.apps.v.b.a.a.22
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public Parcelable[] a(Bundle bundle, String str, Parcelable[] parcelableArr) {
            return bundle.getParcelableArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, Parcelable[] parcelableArr) {
            bundle.putParcelableArray(str, parcelableArr);
        }
    };
    public static final b<ArrayList<? extends Parcelable>> chR = new b<ArrayList<? extends Parcelable>>() { // from class: com.baidu.swan.apps.v.b.a.a.24
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public ArrayList<? extends Parcelable> a(Bundle bundle, String str, ArrayList<? extends Parcelable> arrayList) {
            return bundle.getParcelableArrayList(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, ArrayList<? extends Parcelable> arrayList) {
            bundle.putParcelableArrayList(str, arrayList);
        }
    };
    public static final b<SparseArray<? extends Parcelable>> chS = new b<SparseArray<? extends Parcelable>>() { // from class: com.baidu.swan.apps.v.b.a.a.25
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public SparseArray<? extends Parcelable> a(Bundle bundle, String str, SparseArray<? extends Parcelable> sparseArray) {
            return bundle.getSparseParcelableArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, SparseArray<? extends Parcelable> sparseArray) {
            bundle.putSparseParcelableArray(str, sparseArray);
        }
    };
    public static final b<IBinder> chT = new b<IBinder>() { // from class: com.baidu.swan.apps.v.b.a.a.26
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public IBinder a(Bundle bundle, String str, IBinder iBinder) {
            return bundle.getBinder(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.v.b.a.b
        public void b(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    };
}
