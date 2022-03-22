package androidx.sqlite.db;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class SupportSQLiteQueryBuilder {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern sLimitPattern;
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] mBindArgs;
    public String[] mColumns;
    public boolean mDistinct;
    public String mGroupBy;
    public String mHaving;
    public String mLimit;
    public String mOrderBy;
    public String mSelection;
    public final String mTable;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1205143787, "Landroidx/sqlite/db/SupportSQLiteQueryBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1205143787, "Landroidx/sqlite/db/SupportSQLiteQueryBuilder;");
                return;
            }
        }
        sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }

    public SupportSQLiteQueryBuilder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDistinct = false;
        this.mColumns = null;
        this.mGroupBy = null;
        this.mHaving = null;
        this.mOrderBy = null;
        this.mLimit = null;
        this.mTable = str;
    }

    public static void appendClause(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, sb, str, str2) == null) || isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append(str2);
    }

    public static void appendColumns(StringBuilder sb, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, sb, strArr) == null) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if (i > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(str);
            }
            sb.append(WebvttCueParser.CHAR_SPACE);
        }
    }

    public static SupportSQLiteQueryBuilder builder(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? new SupportSQLiteQueryBuilder(str) : (SupportSQLiteQueryBuilder) invokeL.objValue;
    }

    public static boolean isEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? str == null || str.length() == 0 : invokeL.booleanValue;
    }

    public SupportSQLiteQueryBuilder columns(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            this.mColumns = strArr;
            return this;
        }
        return (SupportSQLiteQueryBuilder) invokeL.objValue;
    }

    public SupportSQLiteQuery create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (isEmpty(this.mGroupBy) && !isEmpty(this.mHaving)) {
                throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
            }
            StringBuilder sb = new StringBuilder(120);
            sb.append("SELECT ");
            if (this.mDistinct) {
                sb.append("DISTINCT ");
            }
            String[] strArr = this.mColumns;
            if (strArr != null && strArr.length != 0) {
                appendColumns(sb, strArr);
            } else {
                sb.append(" * ");
            }
            sb.append(" FROM ");
            sb.append(this.mTable);
            appendClause(sb, " WHERE ", this.mSelection);
            appendClause(sb, " GROUP BY ", this.mGroupBy);
            appendClause(sb, " HAVING ", this.mHaving);
            appendClause(sb, " ORDER BY ", this.mOrderBy);
            appendClause(sb, " LIMIT ", this.mLimit);
            return new SimpleSQLiteQuery(sb.toString(), this.mBindArgs);
        }
        return (SupportSQLiteQuery) invokeV.objValue;
    }

    public SupportSQLiteQueryBuilder distinct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.mDistinct = true;
            return this;
        }
        return (SupportSQLiteQueryBuilder) invokeV.objValue;
    }

    public SupportSQLiteQueryBuilder groupBy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.mGroupBy = str;
            return this;
        }
        return (SupportSQLiteQueryBuilder) invokeL.objValue;
    }

    public SupportSQLiteQueryBuilder having(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.mHaving = str;
            return this;
        }
        return (SupportSQLiteQueryBuilder) invokeL.objValue;
    }

    public SupportSQLiteQueryBuilder limit(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!isEmpty(str) && !sLimitPattern.matcher(str).matches()) {
                throw new IllegalArgumentException("invalid LIMIT clauses:" + str);
            }
            this.mLimit = str;
            return this;
        }
        return (SupportSQLiteQueryBuilder) invokeL.objValue;
    }

    public SupportSQLiteQueryBuilder orderBy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.mOrderBy = str;
            return this;
        }
        return (SupportSQLiteQueryBuilder) invokeL.objValue;
    }

    public SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, objArr)) == null) {
            this.mSelection = str;
            this.mBindArgs = objArr;
            return this;
        }
        return (SupportSQLiteQueryBuilder) invokeLL.objValue;
    }
}
