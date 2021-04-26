package com.alibaba.fastjson.asm;
/* loaded from: classes.dex */
public class ClassWriter {
    public int access;
    public FieldWriter firstField;
    public MethodWriter firstMethod;
    public int index;
    public int interfaceCount;
    public int[] interfaces;
    public Item[] items;
    public final Item key;
    public final Item key2;
    public final Item key3;
    public FieldWriter lastField;
    public MethodWriter lastMethod;
    public int name;
    public final ByteVector pool;
    public int superName;
    public String thisName;
    public int threshold;
    public Item[] typeTable;
    public int version;

    public ClassWriter() {
        this(0);
    }

    private Item get(Item item) {
        Item[] itemArr = this.items;
        Item item2 = itemArr[item.hashCode % itemArr.length];
        while (item2 != null && (item2.type != item.type || !item.isEqualTo(item2))) {
            item2 = item2.next;
        }
        return item2;
    }

    private Item newString(String str) {
        this.key2.set(8, str, null, null);
        Item item = get(this.key2);
        if (item == null) {
            this.pool.put12(8, newUTF8(str));
            int i2 = this.index;
            this.index = i2 + 1;
            Item item2 = new Item(i2, this.key2);
            put(item2);
            return item2;
        }
        return item;
    }

    private void put(Item item) {
        if (this.index > this.threshold) {
            int length = this.items.length;
            int i2 = (length * 2) + 1;
            Item[] itemArr = new Item[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                Item item2 = this.items[i3];
                while (item2 != null) {
                    int i4 = item2.hashCode % i2;
                    Item item3 = item2.next;
                    item2.next = itemArr[i4];
                    itemArr[i4] = item2;
                    item2 = item3;
                }
            }
            this.items = itemArr;
            this.threshold = (int) (i2 * 0.75d);
        }
        int i5 = item.hashCode;
        Item[] itemArr2 = this.items;
        int length2 = i5 % itemArr2.length;
        item.next = itemArr2[length2];
        itemArr2[length2] = item;
    }

    public Item newClassItem(String str) {
        this.key2.set(7, str, null, null);
        Item item = get(this.key2);
        if (item == null) {
            this.pool.put12(7, newUTF8(str));
            int i2 = this.index;
            this.index = i2 + 1;
            Item item2 = new Item(i2, this.key2);
            put(item2);
            return item2;
        }
        return item;
    }

    public Item newConstItem(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            this.key.set(intValue);
            Item item = get(this.key);
            if (item == null) {
                this.pool.putByte(3).putInt(intValue);
                int i2 = this.index;
                this.index = i2 + 1;
                Item item2 = new Item(i2, this.key);
                put(item2);
                return item2;
            }
            return item;
        } else if (obj instanceof String) {
            return newString((String) obj);
        } else {
            if (obj instanceof Type) {
                Type type = (Type) obj;
                return newClassItem(type.sort == 10 ? type.getInternalName() : type.getDescriptor());
            }
            throw new IllegalArgumentException("value " + obj);
        }
    }

    public Item newFieldItem(String str, String str2, String str3) {
        this.key3.set(9, str, str2, str3);
        Item item = get(this.key3);
        if (item == null) {
            int i2 = newClassItem(str).index;
            this.pool.put12(9, i2).putShort(newNameTypeItem(str2, str3).index);
            int i3 = this.index;
            this.index = i3 + 1;
            Item item2 = new Item(i3, this.key3);
            put(item2);
            return item2;
        }
        return item;
    }

    public Item newMethodItem(String str, String str2, String str3, boolean z) {
        int i2 = z ? 11 : 10;
        this.key3.set(i2, str, str2, str3);
        Item item = get(this.key3);
        if (item == null) {
            this.pool.put12(i2, newClassItem(str).index).putShort(newNameTypeItem(str2, str3).index);
            int i3 = this.index;
            this.index = i3 + 1;
            Item item2 = new Item(i3, this.key3);
            put(item2);
            return item2;
        }
        return item;
    }

    public Item newNameTypeItem(String str, String str2) {
        this.key2.set(12, str, str2, null);
        Item item = get(this.key2);
        if (item == null) {
            int newUTF8 = newUTF8(str);
            this.pool.put12(12, newUTF8).putShort(newUTF8(str2));
            int i2 = this.index;
            this.index = i2 + 1;
            Item item2 = new Item(i2, this.key2);
            put(item2);
            return item2;
        }
        return item;
    }

    public int newUTF8(String str) {
        this.key.set(1, str, null, null);
        Item item = get(this.key);
        if (item == null) {
            this.pool.putByte(1).putUTF8(str);
            int i2 = this.index;
            this.index = i2 + 1;
            item = new Item(i2, this.key);
            put(item);
        }
        return item.index;
    }

    public byte[] toByteArray() {
        int i2 = (this.interfaceCount * 2) + 24;
        int i3 = 0;
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = fieldWriter.next) {
            i3++;
            i2 += fieldWriter.getSize();
        }
        int i4 = 0;
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = methodWriter.next) {
            i4++;
            i2 += methodWriter.getSize();
        }
        ByteVector byteVector = new ByteVector(i2 + this.pool.length);
        byteVector.putInt(-889275714).putInt(this.version);
        ByteVector putShort = byteVector.putShort(this.index);
        ByteVector byteVector2 = this.pool;
        putShort.putByteArray(byteVector2.data, 0, byteVector2.length);
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.superName);
        byteVector.putShort(this.interfaceCount);
        for (int i5 = 0; i5 < this.interfaceCount; i5++) {
            byteVector.putShort(this.interfaces[i5]);
        }
        byteVector.putShort(i3);
        for (FieldWriter fieldWriter2 = this.firstField; fieldWriter2 != null; fieldWriter2 = fieldWriter2.next) {
            fieldWriter2.put(byteVector);
        }
        byteVector.putShort(i4);
        for (MethodWriter methodWriter2 = this.firstMethod; methodWriter2 != null; methodWriter2 = methodWriter2.next) {
            methodWriter2.put(byteVector);
        }
        byteVector.putShort(0);
        return byteVector.data;
    }

    public void visit(int i2, int i3, String str, String str2, String[] strArr) {
        this.version = i2;
        this.access = i3;
        this.name = newClassItem(str).index;
        this.thisName = str;
        this.superName = str2 == null ? 0 : newClassItem(str2).index;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.interfaceCount = length;
        this.interfaces = new int[length];
        for (int i4 = 0; i4 < this.interfaceCount; i4++) {
            this.interfaces[i4] = newClassItem(strArr[i4]).index;
        }
    }

    public ClassWriter(int i2) {
        this.index = 1;
        this.pool = new ByteVector();
        Item[] itemArr = new Item[256];
        this.items = itemArr;
        this.threshold = (int) (itemArr.length * 0.75d);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
    }
}
