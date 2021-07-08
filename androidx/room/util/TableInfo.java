package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.room.ColumnInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
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

        public Column(String str, String str2, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = i2;
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
                if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    return 2;
                }
                if (upperCase.contains("BLOB")) {
                    return 5;
                }
                return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
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
                return this.name.equals(column.name) && this.notNull == column.notNull && this.affinity == column.affinity;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
            }
            return invokeV.intValue;
        }

        public boolean isPrimaryKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.primaryKeyPosition > 0 : invokeV.booleanValue;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.referenceTable.equals(foreignKey.referenceTable) && this.onDelete.equals(foreignKey.onDelete) && this.onUpdate.equals(foreignKey.onUpdate) && this.columnNames.equals(foreignKey.columnNames)) {
                    return this.referenceColumnNames.equals(foreignKey.referenceColumnNames);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode() : invokeV.intValue;
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

        public ForeignKeyWithSequence(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mId = i2;
            this.mSequence = i3;
            this.mFrom = str;
            this.mTo = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull ForeignKeyWithSequence foreignKeyWithSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, foreignKeyWithSequence)) == null) {
                int i2 = this.mId - foreignKeyWithSequence.mId;
                return i2 == 0 ? this.mSequence - foreignKeyWithSequence.mSequence : i2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.unique == index.unique && this.columns.equals(index.columns)) {
                    if (this.name.startsWith(DEFAULT_PREFIX)) {
                        return index.name.startsWith(DEFAULT_PREFIX);
                    }
                    return this.name.equals(index.name);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return ((((this.name.startsWith(DEFAULT_PREFIX) ? -1184239155 : this.name.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode();
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

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map, set, set2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.name = str;
        this.columns = Collections.unmodifiableMap(map);
        this.foreignKeys = Collections.unmodifiableSet(set);
        this.indices = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, supportSQLiteDatabase, str)) == null) ? new TableInfo(str, readColumns(supportSQLiteDatabase, str), readForeignKeys(supportSQLiteDatabase, str), readIndices(supportSQLiteDatabase, str)) : (TableInfo) invokeLL.objValue;
    }

    public static Map<String, Column> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, supportSQLiteDatabase, str)) == null) {
            Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
            HashMap hashMap = new HashMap();
            try {
                if (query.getColumnCount() > 0) {
                    int columnIndex = query.getColumnIndex("name");
                    int columnIndex2 = query.getColumnIndex("type");
                    int columnIndex3 = query.getColumnIndex("notnull");
                    int columnIndex4 = query.getColumnIndex("pk");
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndex);
                        hashMap.put(string, new Column(string, query.getString(columnIndex2), query.getInt(columnIndex3) != 0, query.getInt(columnIndex4)));
                    }
                }
                return hashMap;
            } finally {
                query.close();
            }
        }
        return (Map) invokeLL.objValue;
    }

    public static List<ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cursor)) == null) {
            int columnIndex = cursor.getColumnIndex("id");
            int columnIndex2 = cursor.getColumnIndex(IAdRequestParam.SEQ);
            int columnIndex3 = cursor.getColumnIndex("from");
            int columnIndex4 = cursor.getColumnIndex("to");
            int count = cursor.getCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < count; i2++) {
                cursor.moveToPosition(i2);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, supportSQLiteDatabase, str)) == null) {
            HashSet hashSet = new HashSet();
            Cursor query = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex = query.getColumnIndex("id");
                int columnIndex2 = query.getColumnIndex(IAdRequestParam.SEQ);
                int columnIndex3 = query.getColumnIndex("table");
                int columnIndex4 = query.getColumnIndex("on_delete");
                int columnIndex5 = query.getColumnIndex("on_update");
                List<ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(query);
                int count = query.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    query.moveToPosition(i2);
                    if (query.getInt(columnIndex2) == 0) {
                        int i3 = query.getInt(columnIndex);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (ForeignKeyWithSequence foreignKeyWithSequence : readForeignKeyFieldMappings) {
                            if (foreignKeyWithSequence.mId == i3) {
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
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, supportSQLiteDatabase, str, z)) == null) {
            Cursor query = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
            try {
                int columnIndex = query.getColumnIndex("seqno");
                int columnIndex2 = query.getColumnIndex(IAdRequestParam.CELL_ID);
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

    @Nullable
    public static Set<Index> readIndices(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, supportSQLiteDatabase, str)) == null) {
            Cursor query = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
            try {
                int columnIndex = query.getColumnIndex("name");
                int columnIndex2 = query.getColumnIndex(FilterValue.DEFAULT_FILTER_VALUE);
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
            if (str == null ? tableInfo.name == null : str.equals(tableInfo.name)) {
                Map<String, Column> map = this.columns;
                if (map == null ? tableInfo.columns == null : map.equals(tableInfo.columns)) {
                    Set<ForeignKey> set2 = this.foreignKeys;
                    if (set2 == null ? tableInfo.foreignKeys == null : set2.equals(tableInfo.foreignKeys)) {
                        Set<Index> set3 = this.indices;
                        if (set3 == null || (set = tableInfo.indices) == null) {
                            return true;
                        }
                        return set3.equals(set);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.name;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Map<String, Column> map = this.columns;
            int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
            Set<ForeignKey> set = this.foreignKeys;
            return hashCode2 + (set != null ? set.hashCode() : 0);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set) {
        this(str, map, set, Collections.emptySet());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map, set};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Map) objArr2[1], (Set) objArr2[2], (Set) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
