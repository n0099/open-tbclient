package com.baidu.ala.widget.multicolumn;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.e;
import c.a.d.o.e.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BdSimplePreLoadListAdapter extends BaseAdapter implements o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListAdapter mAdapter;
    public DataSetObserver mAdapterDataSetObserver;
    public Context mContext;
    public DataSetObserver mDataSetObserver;
    public boolean mIsFilterable;
    public e.b mListPreLoad;

    public BdSimplePreLoadListAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mAdapter = null;
        this.mIsFilterable = false;
        this.mDataSetObserver = null;
        this.mAdapterDataSetObserver = null;
        this.mListPreLoad = null;
        this.mContext = context;
        this.mAdapterDataSetObserver = new DataSetObserver(this) { // from class: com.baidu.ala.widget.multicolumn.BdSimplePreLoadListAdapter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdSimplePreLoadListAdapter this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onChanged();
                    if (this.this$0.mDataSetObserver != null) {
                        this.this$0.mDataSetObserver.onChanged();
                    }
                    if (this.this$0.mListPreLoad != null) {
                        this.this$0.mListPreLoad.onPreLoad();
                    }
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.onInvalidated();
                    if (this.this$0.mDataSetObserver != null) {
                        this.this$0.mDataSetObserver.onInvalidated();
                    }
                }
            }
        };
    }

    @Override // android.widget.Adapter, c.a.d.o.e.o
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public Filter getFilter() {
        InterceptResult invokeV;
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.mIsFilterable || (listAdapter = this.mAdapter) == null) {
                return null;
            }
            return ((Filterable) listAdapter).getFilter();
        }
        return (Filter) invokeV.objValue;
    }

    @Override // android.widget.Adapter, c.a.d.o.e.o
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.getItem(i2);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.getItemId(i2);
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.getView(i2, view, viewGroup);
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    public ListAdapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mAdapter : (ListAdapter) invokeV.objValue;
    }

    public int getWrappedCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return super.hasStableIds();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.BaseAdapter, c.a.d.o.e.o
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.notifyDataSetChanged();
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter instanceof BaseAdapter) {
                ((BaseAdapter) listAdapter).notifyDataSetChanged();
            } else if (listAdapter instanceof WrapperListAdapter) {
                ListAdapter wrappedAdapter = ((WrapperListAdapter) listAdapter).getWrappedAdapter();
                if (wrappedAdapter instanceof BaseAdapter) {
                    ((BaseAdapter) wrappedAdapter).notifyDataSetChanged();
                }
            }
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.notifyDataSetInvalidated();
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter instanceof BaseAdapter) {
                ((BaseAdapter) listAdapter).notifyDataSetInvalidated();
            } else if (listAdapter instanceof WrapperListAdapter) {
                ListAdapter wrappedAdapter = ((WrapperListAdapter) listAdapter).getWrappedAdapter();
                if (wrappedAdapter instanceof BaseAdapter) {
                    ((BaseAdapter) wrappedAdapter).notifyDataSetInvalidated();
                }
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataSetObserver) == null) {
            super.registerDataSetObserver(dataSetObserver);
            this.mDataSetObserver = dataSetObserver;
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(this.mAdapterDataSetObserver);
            }
        }
    }

    public void setAdaper(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, listAdapter) == null) {
            if (this.mAdapter != null) {
                this.mIsFilterable = false;
            }
            this.mAdapter = listAdapter;
            if (listAdapter != null) {
                this.mIsFilterable = listAdapter instanceof Filterable;
            }
            notifyDataSetChanged();
        }
    }

    public void setListPreLoad(e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.mListPreLoad = bVar;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dataSetObserver) == null) {
            try {
                super.unregisterDataSetObserver(dataSetObserver);
                this.mDataSetObserver = dataSetObserver;
                if (this.mAdapter != null) {
                    this.mAdapter.unregisterDataSetObserver(this.mAdapterDataSetObserver);
                }
            } catch (IllegalStateException unused) {
            }
        }
    }
}
