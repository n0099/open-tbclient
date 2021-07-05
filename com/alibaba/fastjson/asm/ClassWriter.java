package com.alibaba.fastjson.asm;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ClassWriter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassWriter() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private Item get(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, item)) == null) {
            Item[] itemArr = this.items;
            Item item2 = itemArr[item.hashCode % itemArr.length];
            while (item2 != null && (item2.type != item.type || !item.isEqualTo(item2))) {
                item2 = item2.next;
            }
            return item2;
        }
        return (Item) invokeL.objValue;
    }

    private Item newString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
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
        return (Item) invokeL.objValue;
    }

    private void put(Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, item) == null) {
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
    }

    public Item newClassItem(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
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
        return (Item) invokeL.objValue;
    }

    public Item newConstItem(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
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
        return (Item) invokeL.objValue;
    }

    public Item newFieldItem(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3)) == null) {
            this.key3.set(9, str, str2, str3);
            Item item = get(this.key3);
            if (item == null) {
                this.pool.put12(9, newClassItem(str).index).putShort(newNameTypeItem(str2, str3).index);
                int i2 = this.index;
                this.index = i2 + 1;
                Item item2 = new Item(i2, this.key3);
                put(item2);
                return item2;
            }
            return item;
        }
        return (Item) invokeLLL.objValue;
    }

    public Item newMethodItem(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
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
        return (Item) invokeCommon.objValue;
    }

    public Item newNameTypeItem(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            this.key2.set(12, str, str2, null);
            Item item = get(this.key2);
            if (item == null) {
                this.pool.put12(12, newUTF8(str)).putShort(newUTF8(str2));
                int i2 = this.index;
                this.index = i2 + 1;
                Item item2 = new Item(i2, this.key2);
                put(item2);
                return item2;
            }
            return item;
        }
        return (Item) invokeLL.objValue;
    }

    public int newUTF8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
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
        return invokeL.intValue;
    }

    public byte[] toByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
        return (byte[]) invokeV.objValue;
    }

    public void visit(int i2, int i3, String str, String str2, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, strArr}) == null) {
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
    }

    public ClassWriter(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
