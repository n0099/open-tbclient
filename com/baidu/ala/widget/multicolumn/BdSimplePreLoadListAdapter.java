package com.baidu.ala.widget.multicolumn;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.in;
import com.baidu.tieba.ym;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BdSimplePreLoadListAdapter extends BaseAdapter implements in {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListAdapter mAdapter;
    public DataSetObserver mAdapterDataSetObserver;
    public DataSetObserver mDataSetObserver;
    public boolean mIsFilterable;
    public ym.b mListPreLoad;

    public BdSimplePreLoadListAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdapter = null;
        this.mIsFilterable = false;
        this.mDataSetObserver = null;
        this.mAdapterDataSetObserver = null;
        this.mListPreLoad = null;
        this.mAdapterDataSetObserver = new DataSetObserver(this) { // from class: com.baidu.ala.widget.multicolumn.BdSimplePreLoadListAdapter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdSimplePreLoadListAdapter this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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

    @Override // android.widget.Adapter, com.baidu.tieba.in
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.getItem(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.getItemId(i);
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dataSetObserver) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048586, this, listAdapter) == null) {
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

    public void setListPreLoad(ym.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.mListPreLoad = bVar;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dataSetObserver) == null) {
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

    @Override // android.widget.Adapter, com.baidu.tieba.in
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
            if (this.mIsFilterable && (listAdapter = this.mAdapter) != null) {
                return ((Filterable) listAdapter).getFilter();
            }
            return null;
        }
        return (Filter) invokeV.objValue;
    }

    public ListAdapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mAdapter;
        }
        return (ListAdapter) invokeV.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return super.hasStableIds();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.BaseAdapter, com.baidu.tieba.in
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.getView(i, view2, viewGroup);
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
