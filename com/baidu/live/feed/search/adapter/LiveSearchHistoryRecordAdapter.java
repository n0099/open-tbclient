package com.baidu.live.feed.search.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter;
import com.baidu.live.feed.search.holder.LiveSearchCompleteEntranceViewHolder;
import com.baidu.live.feed.search.holder.LiveSearchDeleteEntranceViewHolder;
import com.baidu.live.feed.search.holder.LiveSearchDeleteStatusViewHolder;
import com.baidu.live.feed.search.holder.LiveSearchHistoryRecordViewHolder;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u000256B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b3\u00104J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0017\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u001d\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0019\u0010&\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R*\u00101\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010/j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`08\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00067"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "completeClick", "()V", "", "getItemCount", "()I", CriusAttrConstants.POSITION, "getItemViewType", "(I)I", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "", "historyRecordList", "setList", "(Ljava/util/List;)V", "trashClick", "content", "num", "wordNumCheck", "(Ljava/lang/String;I)Ljava/lang/String;", "Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter$recordListener;", "deleteListener", "Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter$recordListener;", "getDeleteListener", "()Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter$recordListener;", "setDeleteListener", "(Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter$recordListener;)V", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "Landroid/view/View;", "mView", "Landroid/view/View;", "recordList", "Ljava/util/List;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "typeList", "Ljava/util/ArrayList;", "<init>", "(Landroid/content/Context;)V", "Companion", "recordListener", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveSearchHistoryRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final int ITEM_TYPE_COMPLETE_ENTRANCE = 2;
    public static final int ITEM_TYPE_DELETE = 4;
    public static final int ITEM_TYPE_DELETE_ENTRANCE = 1;
    public static final int ITEM_TYPE_RECORD = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public recordListener deleteListener;
    public final Context mContext;
    public View mView;
    public final List<String> recordList;
    public ArrayList<Integer> typeList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter$recordListener;", "Lkotlin/Any;", "", "deleteAllRecord", "()V", "", CriusAttrConstants.POSITION, "deleteClick", "(I)V", "", "editText", "pn", "", "isSearch", "historyItemClick", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface recordListener {
        void deleteAllRecord();

        void deleteClick(int i);

        void historyItemClick(String str, String str2, boolean z, int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1655381586, "Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1655381586, "Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter$Companion;", "", "ITEM_TYPE_COMPLETE_ENTRANCE", "I", "ITEM_TYPE_DELETE", "ITEM_TYPE_DELETE_ENTRANCE", "ITEM_TYPE_RECORD", "<init>", "()V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LiveSearchHistoryRecordAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.recordList = new ArrayList();
        this.typeList = new ArrayList<>();
    }

    public final void setList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            List<String> list2 = this.recordList;
            if (list2 != null) {
                list2.clear();
            }
            ArrayList<Integer> arrayList = this.typeList;
            if (arrayList != null) {
                arrayList.clear();
            }
            List<String> list3 = this.recordList;
            if (list3 != null) {
                list3.addAll(list);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> arrayList2 = this.typeList;
                if (arrayList2 != null) {
                    arrayList2.add(3);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ArrayList<Integer> arrayList = this.typeList;
            if (arrayList != null) {
                num = arrayList.get(i);
            } else {
                num = null;
            }
            if (num == null) {
                Intrinsics.throwNpe();
            }
            return num.intValue();
        }
        return invokeI.intValue;
    }

    public final void setDeleteListener(recordListener recordlistener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, recordlistener) == null) {
            this.deleteListener = recordlistener;
        }
    }

    public final void completeClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ArrayList<Integer> arrayList = this.typeList;
            if (arrayList != null) {
                arrayList.clear();
            }
            List<String> list = this.recordList;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ArrayList<Integer> arrayList2 = this.typeList;
                    if (arrayList2 != null) {
                        arrayList2.add(3);
                    }
                }
                notifyDataSetChanged();
                return;
            }
            notifyDataSetChanged();
        }
    }

    public final void trashClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList<Integer> arrayList = this.typeList;
            if (arrayList != null) {
                arrayList.clear();
            }
            List<String> list = this.recordList;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ArrayList<Integer> arrayList2 = this.typeList;
                    if (arrayList2 != null) {
                        arrayList2.add(4);
                    }
                }
                notifyDataSetChanged();
                return;
            }
            notifyDataSetChanged();
        }
    }

    public final recordListener getDeleteListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.deleteListener;
        }
        return (recordListener) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<String> list = this.recordList;
            if (list != null) {
                return list.size();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public final Context getMContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    String str = null;
                    if (itemViewType != 3) {
                        if (itemViewType == 4) {
                            LiveSearchDeleteStatusViewHolder liveSearchDeleteStatusViewHolder = (LiveSearchDeleteStatusViewHolder) viewHolder;
                            liveSearchDeleteStatusViewHolder.a(i);
                            TextView textView = liveSearchDeleteStatusViewHolder.c;
                            List<String> list = this.recordList;
                            if (list != null) {
                                str = list.get(i);
                            }
                            textView.setText(str);
                            liveSearchDeleteStatusViewHolder.b.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter$onBindViewHolder$5
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ int $position;
                                public final /* synthetic */ LiveSearchHistoryRecordAdapter this$0;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.$position = i;
                                }

                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view2) {
                                    LiveSearchHistoryRecordAdapter.recordListener deleteListener;
                                    Interceptable interceptable2 = $ic;
                                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && (deleteListener = this.this$0.getDeleteListener()) != null) {
                                        deleteListener.deleteClick(this.$position);
                                    }
                                }
                            });
                            liveSearchDeleteStatusViewHolder.c.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter$onBindViewHolder$6
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ int $position;
                                public final /* synthetic */ LiveSearchHistoryRecordAdapter this$0;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.$position = i;
                                }

                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view2) {
                                    LiveSearchHistoryRecordAdapter.recordListener deleteListener;
                                    Interceptable interceptable2 = $ic;
                                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && (deleteListener = this.this$0.getDeleteListener()) != null) {
                                        deleteListener.deleteClick(this.$position);
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    LiveSearchHistoryRecordViewHolder liveSearchHistoryRecordViewHolder = (LiveSearchHistoryRecordViewHolder) viewHolder;
                    liveSearchHistoryRecordViewHolder.a(i);
                    TextView textView2 = liveSearchHistoryRecordViewHolder.b;
                    List<String> list2 = this.recordList;
                    if (list2 != null) {
                        str = list2.get(i);
                    }
                    textView2.setText(str);
                    liveSearchHistoryRecordViewHolder.b.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter$onBindViewHolder$4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int $position;
                        public final /* synthetic */ LiveSearchHistoryRecordAdapter this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.$position = i;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                            r5 = r4.this$0.recordList;
                         */
                        @Override // android.view.View.OnClickListener
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void onClick(View view2) {
                            List list3;
                            String str2;
                            LiveSearchHistoryRecordAdapter.recordListener deleteListener;
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && list3 != null && (str2 = (String) list3.get(this.$position)) != null && (deleteListener = this.this$0.getDeleteListener()) != null) {
                                deleteListener.historyItemClick(str2, "0", false, this.$position);
                            }
                        }
                    });
                    return;
                }
                LiveSearchCompleteEntranceViewHolder liveSearchCompleteEntranceViewHolder = (LiveSearchCompleteEntranceViewHolder) viewHolder;
                liveSearchCompleteEntranceViewHolder.c.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter$onBindViewHolder$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveSearchHistoryRecordAdapter this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ArrayList arrayList;
                        ArrayList arrayList2;
                        List list3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                            return;
                        }
                        arrayList = this.this$0.typeList;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        arrayList2 = this.this$0.typeList;
                        if (arrayList2 != null) {
                            arrayList2.add(1);
                        }
                        list3 = this.this$0.recordList;
                        if (list3 != null) {
                            list3.clear();
                        }
                        this.this$0.notifyDataSetChanged();
                        LiveSearchHistoryRecordAdapter.recordListener deleteListener = this.this$0.getDeleteListener();
                        if (deleteListener != null) {
                            deleteListener.deleteAllRecord();
                        }
                    }
                });
                liveSearchCompleteEntranceViewHolder.b.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter$onBindViewHolder$3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveSearchHistoryRecordAdapter this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ArrayList arrayList;
                        ArrayList arrayList2;
                        List list3;
                        List list4;
                        Integer num;
                        ArrayList arrayList3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                            return;
                        }
                        arrayList = this.this$0.typeList;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        arrayList2 = this.this$0.typeList;
                        if (arrayList2 != null) {
                            arrayList2.add(1);
                        }
                        list3 = this.this$0.recordList;
                        if (list3 == null) {
                            this.this$0.notifyDataSetChanged();
                            return;
                        }
                        list4 = this.this$0.recordList;
                        if (list4 != null) {
                            num = Integer.valueOf(list4.size());
                        } else {
                            num = null;
                        }
                        int intValue = num.intValue();
                        for (int i2 = 1; i2 < intValue; i2++) {
                            arrayList3 = this.this$0.typeList;
                            if (arrayList3 != null) {
                                arrayList3.add(3);
                            }
                        }
                        this.this$0.notifyDataSetChanged();
                    }
                });
                StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                layoutParams.setFullSpan(true);
                View view2 = liveSearchCompleteEntranceViewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view2, "completeEntranceHolder.itemView");
                view2.setLayoutParams(layoutParams);
                return;
            }
            LiveSearchDeleteEntranceViewHolder liveSearchDeleteEntranceViewHolder = (LiveSearchDeleteEntranceViewHolder) viewHolder;
            liveSearchDeleteEntranceViewHolder.a(i);
            liveSearchDeleteEntranceViewHolder.c.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter$onBindViewHolder$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveSearchHistoryRecordAdapter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    List list3;
                    List list4;
                    ArrayList arrayList3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view3) != null) {
                        return;
                    }
                    arrayList = this.this$0.typeList;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    arrayList2 = this.this$0.typeList;
                    if (arrayList2 != null) {
                        arrayList2.add(2);
                    }
                    list3 = this.this$0.recordList;
                    if (list3 == null) {
                        this.this$0.notifyDataSetChanged();
                        return;
                    }
                    list4 = this.this$0.recordList;
                    int size = list4.size();
                    for (int i2 = 1; i2 < size; i2++) {
                        arrayList3 = this.this$0.typeList;
                        if (arrayList3 != null) {
                            arrayList3.add(4);
                        }
                    }
                    this.this$0.notifyDataSetChanged();
                }
            });
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
            layoutParams2.setFullSpan(true);
            View view3 = liveSearchDeleteEntranceViewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "deleteEntranceHolder.itemView");
            view3.setLayoutParams(layoutParams2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            if (i == 1) {
                return new LiveSearchDeleteEntranceViewHolder(View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d04c5, null));
            }
            if (i == 2) {
                return new LiveSearchCompleteEntranceViewHolder(View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d04c8, null));
            }
            if (i == 3) {
                return new LiveSearchHistoryRecordViewHolder(View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d04c6, null));
            }
            return new LiveSearchDeleteStatusViewHolder(View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d04c7, null));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public final String wordNumCheck(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i)) == null) {
            if (str.length() > i) {
                StringBuilder sb = new StringBuilder();
                String substring = str.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append(StringHelper.STRING_MORE);
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }
}
