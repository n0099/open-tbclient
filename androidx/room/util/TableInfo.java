package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.net.MailTo;
import androidx.core.view.InputDeviceCompat;
import androidx.room.ColumnInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class TableInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    @Nullable
    public final Set<Index> indices;
    public final String name;

    /* loaded from: classes.dex */
    public static class Column {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @ColumnInfo.SQLiteTypeAffinity
        public final int affinity;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public Column(String str, String str2, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = i;
            this.affinity = findAffinity(str2);
        }

        @ColumnInfo.SQLiteTypeAffinity
        public static int findAffinity(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (str == null) {
                    return 5;
                }
                String upperCase = str.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    return 3;
                }
                if (!upperCase.contains("CHAR") && !upperCase.contains("CLOB") && !upperCase.contains("TEXT")) {
                    if (upperCase.contains("BLOB")) {
                        return 5;
                    }
                    if (!upperCase.contains("REAL") && !upperCase.contains("FLOA") && !upperCase.contains("DOUB")) {
                        return 1;
                    }
                    return 4;
                }
                return 2;
            }
            return invokeL.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Column.class != obj.getClass()) {
                    return false;
                }
                Column column = (Column) obj;
                if (Build.VERSION.SDK_INT >= 20) {
                    if (this.primaryKeyPosition != column.primaryKeyPosition) {
                        return false;
                    }
                } else if (isPrimaryKey() != column.isPrimaryKey()) {
                    return false;
                }
                if (this.name.equals(column.name) && this.notNull == column.notNull && this.affinity == column.affinity) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int hashCode = ((this.name.hashCode() * 31) + this.affinity) * 31;
                if (this.notNull) {
                    i = 1231;
                } else {
                    i = 1237;
                }
                return ((hashCode + i) * 31) + this.primaryKeyPosition;
            }
            return invokeV.intValue;
        }

        public boolean isPrimaryKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.primaryKeyPosition > 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Column{name='" + this.name + "', type='" + this.type + "', affinity='" + this.affinity + "', notNull=" + this.notNull + ", primaryKeyPosition=" + this.primaryKeyPosition + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static class ForeignKey {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final List<String> columnNames;
        @NonNull
        public final String onDelete;
        @NonNull
        public final String onUpdate;
        @NonNull
        public final List<String> referenceColumnNames;
        @NonNull
        public final String referenceTable;

        public ForeignKey(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<String> list, @NonNull List<String> list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = Collections.unmodifiableList(list);
            this.referenceColumnNames = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || ForeignKey.class != obj.getClass()) {
                    return false;
                }
                ForeignKey foreignKey = (ForeignKey) obj;
                if (!this.referenceTable.equals(foreignKey.referenceTable) || !this.onDelete.equals(foreignKey.onDelete) || !this.onUpdate.equals(foreignKey.onUpdate) || !this.columnNames.equals(foreignKey.columnNames)) {
                    return false;
                }
                return this.referenceColumnNames.equals(foreignKey.referenceColumnNames);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + "', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String mFrom;
        public final int mId;
        public final int mSequence;
        public final String mTo;

        public ForeignKeyWithSequence(int i, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mId = i;
            this.mSequence = i2;
            this.mFrom = str;
            this.mTo = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull ForeignKeyWithSequence foreignKeyWithSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, foreignKeyWithSequence)) == null) {
                int i = this.mId - foreignKeyWithSequence.mId;
                if (i == 0) {
                    return this.mSequence - foreignKeyWithSequence.mSequence;
                }
                return i;
            }
            return invokeL.intValue;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static class Index {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DEFAULT_PREFIX = "index_";
        public transient /* synthetic */ FieldHolder $fh;
        public final List<String> columns;
        public final String name;
        public final boolean unique;

        public Index(String str, boolean z, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.unique = z;
            this.columns = list;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Index.class != obj.getClass()) {
                    return false;
                }
                Index index = (Index) obj;
                if (this.unique != index.unique || !this.columns.equals(index.columns)) {
                    return false;
                }
                if (this.name.startsWith(DEFAULT_PREFIX)) {
                    return index.name.startsWith(DEFAULT_PREFIX);
                }
                return this.name.equals(index.name);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.name.startsWith(DEFAULT_PREFIX)) {
                    hashCode = -1184239155;
                } else {
                    hashCode = this.name.hashCode();
                }
                return (((hashCode * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set) {
        this(str, map, set, Collections.emptySet());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map, set};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Map) objArr2[1], (Set) objArr2[2], (Set) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        Set<Index> unmodifiableSet;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map, set, set2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.name = str;
        this.columns = Collections.unmodifiableMap(map);
        this.foreignKeys = Collections.unmodifiableSet(set);
        if (set2 == null) {
            unmodifiableSet = null;
        } else {
            unmodifiableSet = Collections.unmodifiableSet(set2);
        }
        this.indices = unmodifiableSet;
    }

    public static TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, supportSQLiteDatabase, str)) == null) {
            return new TableInfo(str, readColumns(supportSQLiteDatabase, str), readForeignKeys(supportSQLiteDatabase, str), readIndices(supportSQLiteDatabase, str));
        }
        return (TableInfo) invokeLL.objValue;
    }

    public static Map<String, Column> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, supportSQLiteDatabase, str)) == null) {
            Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
            HashMap hashMap = new HashMap();
            try {
                if (query.getColumnCount() > 0) {
                    int columnIndex = query.getColumnIndex("name");
                    int columnIndex2 = query.getColumnIndex("type");
                    int columnIndex3 = query.getColumnIndex("notnull");
                    int columnIndex4 = query.getColumnIndex(PushConstants.URI_PACKAGE_NAME);
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndex);
                        String string2 = query.getString(columnIndex2);
                        if (query.getInt(columnIndex3) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        hashMap.put(string, new Column(string, string2, z, query.getInt(columnIndex4)));
                    }
                }
                return hashMap;
            } finally {
                query.close();
            }
        }
        return (Map) invokeLL.objValue;
    }

    @Nullable
    public static Set<Index> readIndices(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, supportSQLiteDatabase, str)) == null) {
            Cursor query = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
            try {
                int columnIndex = query.getColumnIndex("name");
                int columnIndex2 = query.getColumnIndex("origin");
                int columnIndex3 = query.getColumnIndex("unique");
                if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                    HashSet hashSet = new HashSet();
                    while (query.moveToNext()) {
                        if ("c".equals(query.getString(columnIndex2))) {
                            String string = query.getString(columnIndex);
                            boolean z = true;
                            if (query.getInt(columnIndex3) != 1) {
                                z = false;
                            }
                            Index readIndex = readIndex(supportSQLiteDatabase, string, z);
                            if (readIndex == null) {
                                return null;
                            }
                            hashSet.add(readIndex);
                        }
                    }
                    return hashSet;
                }
                return null;
            } finally {
                query.close();
            }
        }
        return (Set) invokeLL.objValue;
    }

    public static List<ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cursor)) == null) {
            int columnIndex = cursor.getColumnIndex("id");
            int columnIndex2 = cursor.getColumnIndex("seq");
            int columnIndex3 = cursor.getColumnIndex("from");
            int columnIndex4 = cursor.getColumnIndex(MailTo.TO);
            int count = cursor.getCount();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < count; i++) {
                cursor.moveToPosition(i);
                arrayList.add(new ForeignKeyWithSequence(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
            }
            Collections.sort(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static Set<ForeignKey> readForeignKeys(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, supportSQLiteDatabase, str)) == null) {
            HashSet hashSet = new HashSet();
            Cursor query = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex = query.getColumnIndex("id");
                int columnIndex2 = query.getColumnIndex("seq");
                int columnIndex3 = query.getColumnIndex("table");
                int columnIndex4 = query.getColumnIndex("on_delete");
                int columnIndex5 = query.getColumnIndex("on_update");
                List<ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(query);
                int count = query.getCount();
                for (int i = 0; i < count; i++) {
                    query.moveToPosition(i);
                    if (query.getInt(columnIndex2) == 0) {
                        int i2 = query.getInt(columnIndex);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (ForeignKeyWithSequence foreignKeyWithSequence : readForeignKeyFieldMappings) {
                            if (foreignKeyWithSequence.mId == i2) {
                                arrayList.add(foreignKeyWithSequence.mFrom);
                                arrayList2.add(foreignKeyWithSequence.mTo);
                            }
                        }
                        hashSet.add(new ForeignKey(query.getString(columnIndex3), query.getString(columnIndex4), query.getString(columnIndex5), arrayList, arrayList2));
                    }
                }
                return hashSet;
            } finally {
                query.close();
            }
        }
        return (Set) invokeLL.objValue;
    }

    @Nullable
    public static Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, supportSQLiteDatabase, str, z)) == null) {
            Cursor query = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
            try {
                int columnIndex = query.getColumnIndex("seqno");
                int columnIndex2 = query.getColumnIndex("cid");
                int columnIndex3 = query.getColumnIndex("name");
                if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (query.moveToNext()) {
                        if (query.getInt(columnIndex2) >= 0) {
                            treeMap.put(Integer.valueOf(query.getInt(columnIndex)), query.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    return new Index(str, z, arrayList);
                }
                return null;
            } finally {
                query.close();
            }
        }
        return (Index) invokeLLZ.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Set<Index> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TableInfo.class != obj.getClass()) {
                return false;
            }
            TableInfo tableInfo = (TableInfo) obj;
            String str = this.name;
            if (str == null ? tableInfo.name != null : !str.equals(tableInfo.name)) {
                return false;
            }
            Map<String, Column> map = this.columns;
            if (map == null ? tableInfo.columns != null : !map.equals(tableInfo.columns)) {
                return false;
            }
            Set<ForeignKey> set2 = this.foreignKeys;
            if (set2 == null ? tableInfo.foreignKeys != null : !set2.equals(tableInfo.foreignKeys)) {
                return false;
            }
            Set<Index> set3 = this.indices;
            if (set3 == null || (set = tableInfo.indices) == null) {
                return true;
            }
            return set3.equals(set);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.name;
            int i3 = 0;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            int i4 = i * 31;
            Map<String, Column> map = this.columns;
            if (map != null) {
                i2 = map.hashCode();
            } else {
                i2 = 0;
            }
            int i5 = (i4 + i2) * 31;
            Set<ForeignKey> set = this.foreignKeys;
            if (set != null) {
                i3 = set.hashCode();
            }
            return i5 + i3;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
        }
        return (String) invokeV.objValue;
    }
}
