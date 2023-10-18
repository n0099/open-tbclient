package com.baidu.android.ext.widget.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class BdContextMenuView extends FrameLayout implements BdMenu.OnMenuSetChangedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BdContextMenuView";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public boolean mLayoutInCenter;
    public ListViewAdapter mListAdapter;
    public ListView mListView;
    public boolean mMenuLoaded;

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdMenuItem) == null) {
        }
    }

    /* loaded from: classes.dex */
    public class ListViewAdapter extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public List<BdMenuItem> mDataList;
        public final /* synthetic */ BdContextMenuView this$0;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.longValue;
        }

        /* loaded from: classes.dex */
        public class ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public ImageView mListIcon;
            public TextView mListName;
            public final /* synthetic */ ListViewAdapter this$1;

            public ViewHolder(ListViewAdapter listViewAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {listViewAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = listViewAdapter;
            }
        }

        public ListViewAdapter(BdContextMenuView bdContextMenuView, Context context, List<BdMenuItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdContextMenuView, context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdContextMenuView;
            this.mDataList = list;
            this.mContext = context;
        }

        private void setBackgroundSelector(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65537, this, view2, i) == null) {
                if (getCount() == 1) {
                    view2.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080550));
                } else if (i == 0) {
                    view2.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080551));
                } else if (i == getCount() - 1) {
                    view2.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08054e));
                } else {
                    view2.setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08054f));
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mDataList.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return this.mDataList.get(i);
            }
            return invokeI.objValue;
        }

        public void onItemClicked(int i) {
            BdMenuItem bdMenuItem;
            BdMenuItem.OnItemClickListener onClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (onClickListener = (bdMenuItem = this.mDataList.get(i)).getOnClickListener()) != null) {
                onClickListener.onClick(bdMenuItem);
            }
        }

        public void setData(List<BdMenuItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
                this.mDataList = list;
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams", "NewApi"})
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            ViewHolder viewHolder;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0620, (ViewGroup) null);
                    viewHolder = new ViewHolder(this);
                    viewHolder.mListIcon = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911cd);
                    TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0911fd);
                    viewHolder.mListName = textView;
                    textView.setTextColor(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f06065b));
                    setBackgroundSelector(view2, i);
                    view2.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) view2.getTag();
                }
                BdMenuItem bdMenuItem = this.mDataList.get(i);
                viewHolder.mListName.setText(bdMenuItem.getTitle());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.mListName.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewHolder.mListIcon.getLayoutParams();
                if (bdMenuItem.getIcon() != null) {
                    viewHolder.mListIcon.setVisibility(0);
                    viewHolder.mListIcon.setImageDrawable(bdMenuItem.getIcon());
                    if (DeviceUtils.OSInfo.hasJellyBeanMR1()) {
                        layoutParams.setMarginStart(this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027f));
                    } else {
                        layoutParams.setMargins(this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027f), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    }
                    viewHolder.mListName.setLayoutParams(layoutParams);
                } else {
                    viewHolder.mListIcon.setVisibility(8);
                    if (DeviceUtils.OSInfo.hasJellyBeanMR1()) {
                        layoutParams.setMarginStart(this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027d));
                    } else {
                        layoutParams.setMargins(this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027f), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    }
                    viewHolder.mListName.setLayoutParams(layoutParams);
                }
                if (this.this$0.mLayoutInCenter) {
                    ((LinearLayout) view2).setGravity(17);
                    layoutParams.width = -2;
                    if (bdMenuItem.getIcon() != null) {
                        if (DeviceUtils.OSInfo.hasJellyBeanMR1()) {
                            layoutParams2.setMarginStart(0);
                        } else {
                            layoutParams2.setMargins(0, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                        }
                        viewHolder.mListIcon.setLayoutParams(layoutParams2);
                    } else {
                        if (DeviceUtils.OSInfo.hasJellyBeanMR1()) {
                            layoutParams.setMarginStart(0);
                        } else {
                            layoutParams.setMargins(0, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                        }
                        viewHolder.mListName.setLayoutParams(layoutParams);
                    }
                }
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    public void layoutMenu(List<BdMenuItem> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || this.mMenuLoaded) {
            return;
        }
        ListViewAdapter listViewAdapter = this.mListAdapter;
        if (listViewAdapter == null) {
            ListViewAdapter listViewAdapter2 = new ListViewAdapter(this, this.mContext, list);
            this.mListAdapter = listViewAdapter2;
            this.mListView.setAdapter((ListAdapter) listViewAdapter2);
        } else {
            listViewAdapter.setData(list);
        }
        this.mMenuLoaded = true;
    }

    public void setLayoutInCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mLayoutInCenter = z;
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            setBackground(this.mContext.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08054d));
            ListView listView = new ListView(this.mContext);
            this.mListView = listView;
            listView.setCacheColorHint(0);
            this.mListView.setDivider(getResources().getDrawable(R.color.obfuscated_res_0x7f060659));
            this.mListView.setDividerHeight(1);
            this.mListView.setSelector(new ColorDrawable(0));
            addView(this.mListView, new FrameLayout.LayoutParams(-1, -1));
            this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.baidu.android.ext.widget.menu.BdContextMenuView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdContextMenuView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                        this.this$0.mListAdapter.onItemClicked(i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mMenuLoaded = false;
        }
    }
}
