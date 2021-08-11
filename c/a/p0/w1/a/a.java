package c.a.p0.w1.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<BubbleListData.BubbleData> f27295e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<BubbleChooseActivity> f27296f;

    /* renamed from: g  reason: collision with root package name */
    public int f27297g;

    /* renamed from: h  reason: collision with root package name */
    public int f27298h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27299i;

    public a(TbPageContext<BubbleChooseActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27295e = new ArrayList();
        this.f27296f = tbPageContext;
        this.f27297g = (int) tbPageContext.getResources().getDimension(R.dimen.ds30);
        this.f27298h = (int) this.f27296f.getResources().getDimension(R.dimen.ds30);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public BubbleListData.BubbleData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<BubbleListData.BubbleData> list = this.f27295e;
            if (list != null) {
                if (i2 >= 0 || i2 < list.size()) {
                    return this.f27295e.get(i2);
                }
                return null;
            }
            return null;
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    public List<BubbleListData.BubbleData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27295e : (List) invokeV.objValue;
    }

    public void c(List<BubbleListData.BubbleData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f27295e.clear();
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            this.f27295e.add(bubbleData);
            this.f27295e.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f27299i = z;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<BubbleListData.BubbleData> list = this.f27295e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        BubbleView bubbleView;
        BubbleView bubbleView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                bubbleView2 = new BubbleView(this.f27296f.getPageActivity());
                bubbleView = bubbleView2;
            } else {
                bubbleView = view;
                bubbleView2 = (BubbleView) view;
            }
            if (i2 == 0 || i2 == 1) {
                bubbleView2.setPadding(0, this.f27298h, 0, 0);
            }
            if (getCount() % 2 == 0) {
                if (i2 == getCount() - 1 || i2 == getCount() - 2) {
                    bubbleView2.setPadding(0, bubbleView2.getPaddingTop(), 0, this.f27297g);
                }
            } else if (i2 == getCount() - 1) {
                bubbleView2.setPadding(0, bubbleView2.getPaddingTop(), 0, this.f27297g);
            }
            BubbleListData.BubbleData item = getItem(i2);
            if (item != null) {
                bubbleView2.setShowName(true);
                bubbleView2.setData(item, this.f27299i);
            }
            bubbleView2.changeSkinType(this.f27296f);
            return bubbleView;
        }
        return (View) invokeILL.objValue;
    }
}
