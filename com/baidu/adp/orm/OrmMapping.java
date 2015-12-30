package com.baidu.adp.orm;
/* loaded from: classes.dex */
public class OrmMapping {

    /* loaded from: classes.dex */
    public enum OrmType {
        Tboolean,
        Tbyte,
        Tchar,
        Tshort,
        Tint,
        Tlong,
        Tfloat,
        Tdouble,
        CBoolean,
        CByte,
        CCharacter,
        CShort,
        CInteger,
        CLong,
        CFloat,
        CDouble,
        CString,
        Aboolean,
        Abyte,
        Achar,
        Ashort,
        Aint,
        Along,
        Afloat,
        Adouble,
        ABoolean,
        AByte,
        ACharacter,
        AShort,
        AInteger,
        ALong,
        AFloat,
        ADouble,
        AString,
        OrmJson,
        OrmUnknown;

        /* JADX DEBUG: Replace access to removed values field (Ce) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static OrmType[] valuesCustom() {
            OrmType[] valuesCustom = values();
            int length = valuesCustom.length;
            OrmType[] ormTypeArr = new OrmType[length];
            System.arraycopy(valuesCustom, 0, ormTypeArr, 0, length);
            return ormTypeArr;
        }
    }
}
