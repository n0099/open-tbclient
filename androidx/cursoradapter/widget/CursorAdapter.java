package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.cursoradapter.widget.CursorFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    public transient /* synthetic */ FieldHolder $fh;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mAutoRequery;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ChangeObserver mChangeObserver;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Context mContext;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Cursor mCursor;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CursorFilter mCursorFilter;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DataSetObserver mDataSetObserver;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mDataValid;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FilterQueryProvider mFilterQueryProvider;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int mRowIDColumn;

    public abstract void bindView(View view2, Context context, Cursor cursor);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    /* loaded from: classes.dex */
    public class ChangeObserver extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CursorAdapter this$0;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangeObserver(CursorAdapter cursorAdapter) {
            super(new Handler());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cursorAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cursorAdapter;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.this$0.onContentChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public class MyDataSetObserver extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CursorAdapter this$0;

        public MyDataSetObserver(CursorAdapter cursorAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cursorAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cursorAdapter;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CursorAdapter cursorAdapter = this.this$0;
                cursorAdapter.mDataValid = true;
                cursorAdapter.notifyDataSetChanged();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                CursorAdapter cursorAdapter = this.this$0;
                cursorAdapter.mDataValid = false;
                cursorAdapter.notifyDataSetInvalidated();
            }
        }
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cursor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(context, cursor, 1);
    }

    public CursorAdapter(Context context, Cursor cursor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cursor, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(context, cursor, i);
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cursor, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        init(context, cursor, i);
    }

    public void changeCursor(Cursor cursor) {
        Cursor swapCursor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor) == null) && (swapCursor = swapCursor(cursor)) != null) {
            swapCursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            if (cursor == null) {
                return "";
            }
            return cursor.toString();
        }
        return (CharSequence) invokeL.objValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.mDataValid && (cursor = this.mCursor) != null) {
                cursor.moveToPosition(i);
                return this.mCursor;
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (!this.mDataValid || (cursor = this.mCursor) == null || !cursor.moveToPosition(i)) {
                return 0L;
            }
            return this.mCursor.getLong(this.mRowIDColumn);
        }
        return invokeI.longValue;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, charSequence)) == null) {
            FilterQueryProvider filterQueryProvider = this.mFilterQueryProvider;
            if (filterQueryProvider != null) {
                return filterQueryProvider.runQuery(charSequence);
            }
            return this.mCursor;
        }
        return (Cursor) invokeL.objValue;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, filterQueryProvider) == null) {
            this.mFilterQueryProvider = filterQueryProvider;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mDataValid && (cursor = this.mCursor) != null) {
                return cursor.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mCursor;
        }
        return (Cursor) invokeV.objValue;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mCursorFilter == null) {
                this.mCursorFilter = new CursorFilter(this);
            }
            return this.mCursorFilter;
        }
        return (Filter) invokeV.objValue;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mFilterQueryProvider;
        }
        return (FilterQueryProvider) invokeV.objValue;
    }

    public void onContentChanged() {
        Cursor cursor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.mAutoRequery && (cursor = this.mCursor) != null && !cursor.isClosed()) {
            this.mDataValid = this.mCursor.requery();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            if (this.mDataValid) {
                this.mCursor.moveToPosition(i);
                if (view2 == null) {
                    view2 = newDropDownView(this.mContext, this.mCursor, viewGroup);
                }
                bindView(view2, this.mContext, this.mCursor);
                return view2;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    @Deprecated
    public void init(Context context, Cursor cursor, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, context, cursor, z) == null) {
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            init(context, cursor, i);
        }
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, context, cursor, viewGroup)) == null) {
            return newView(context, cursor, viewGroup);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (this.mDataValid) {
                if (this.mCursor.moveToPosition(i)) {
                    if (view2 == null) {
                        view2 = newView(this.mContext, this.mCursor, viewGroup);
                    }
                    bindView(view2, this.mContext, this.mCursor);
                    return view2;
                }
                throw new IllegalStateException("couldn't move cursor to position " + i);
            }
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        return (View) invokeILL.objValue;
    }

    public void init(Context context, Cursor cursor, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, context, cursor, i) == null) {
            boolean z = false;
            if ((i & 1) == 1) {
                i |= 2;
                this.mAutoRequery = true;
            } else {
                this.mAutoRequery = false;
            }
            if (cursor != null) {
                z = true;
            }
            this.mCursor = cursor;
            this.mDataValid = z;
            this.mContext = context;
            if (z) {
                i2 = cursor.getColumnIndexOrThrow("_id");
            } else {
                i2 = -1;
            }
            this.mRowIDColumn = i2;
            if ((i & 2) == 2) {
                this.mChangeObserver = new ChangeObserver(this);
                this.mDataSetObserver = new MyDataSetObserver(this);
            } else {
                this.mChangeObserver = null;
                this.mDataSetObserver = null;
            }
            if (z) {
                ChangeObserver changeObserver = this.mChangeObserver;
                if (changeObserver != null) {
                    cursor.registerContentObserver(changeObserver);
                }
                DataSetObserver dataSetObserver = this.mDataSetObserver;
                if (dataSetObserver != null) {
                    cursor.registerDataSetObserver(dataSetObserver);
                }
            }
        }
    }

    public Cursor swapCursor(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, cursor)) == null) {
            Cursor cursor2 = this.mCursor;
            if (cursor == cursor2) {
                return null;
            }
            if (cursor2 != null) {
                ChangeObserver changeObserver = this.mChangeObserver;
                if (changeObserver != null) {
                    cursor2.unregisterContentObserver(changeObserver);
                }
                DataSetObserver dataSetObserver = this.mDataSetObserver;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.mCursor = cursor;
            if (cursor != null) {
                ChangeObserver changeObserver2 = this.mChangeObserver;
                if (changeObserver2 != null) {
                    cursor.registerContentObserver(changeObserver2);
                }
                DataSetObserver dataSetObserver2 = this.mDataSetObserver;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
                this.mDataValid = true;
                notifyDataSetChanged();
            } else {
                this.mRowIDColumn = -1;
                this.mDataValid = false;
                notifyDataSetInvalidated();
            }
            return cursor2;
        }
        return (Cursor) invokeL.objValue;
    }
}
