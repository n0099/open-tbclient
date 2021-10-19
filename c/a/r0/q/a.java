package c.a.r0.q;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f23572e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23573f;

    /* renamed from: g  reason: collision with root package name */
    public List<AccountData> f23574g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f23575h;

    /* renamed from: c.a.r0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C1097a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f23576a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f23577b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f23578c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f23579d;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, C1097a c1097a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23572e = baseActivity;
        this.f23574g = null;
        this.f23573f = false;
        this.f23575h = onClickListener;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23573f : invokeV.booleanValue;
    }

    public void b(List<AccountData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f23574g = list;
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f23573f = z;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<AccountData> list = this.f23574g;
            return (list != null ? list.size() : 0) + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<AccountData> list = this.f23574g;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f23574g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (getItem(i2) != null) {
                return i2;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? getItemId(i2) >= 0 ? 0 : 1 : invokeI.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE, CONST, INVOKE, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ce, code lost:
        if (com.baidu.tbadk.core.TbadkCoreApplication.getInst().getSkinType() == 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e5, code lost:
        if (com.baidu.tbadk.core.TbadkCoreApplication.getInst().getSkinType() != 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e8, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e9, code lost:
        r6.k(r0);
        r5.f23572e.getLayoutMode().j(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f5, code lost:
        return r7;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c layoutMode;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) != null) {
            return (View) invokeILL.objValue;
        }
        try {
            try {
                if (view == null) {
                    if (getItemViewType(i2) == 0) {
                        view = LayoutInflater.from(this.f23572e.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                        bVar = new b(this, null);
                        bVar.f23576a = (TextView) view.findViewById(R.id.account);
                        bVar.f23578c = (ImageView) view.findViewById(R.id.active);
                        TextView textView = (TextView) view.findViewById(R.id.delete);
                        bVar.f23579d = textView;
                        textView.setOnClickListener(this.f23575h);
                        view.setTag(bVar);
                    } else {
                        view = LayoutInflater.from(this.f23572e.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                        bVar = new b(this, null);
                        bVar.f23577b = (TextView) view.findViewById(R.id.add_text);
                        view.setTag(bVar);
                    }
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItemViewType(i2) == 0) {
                    AccountData accountData = (AccountData) getItem(i2);
                    bVar.f23578c.setVisibility(8);
                    bVar.f23579d.setVisibility(8);
                    bVar.f23579d.setTag(accountData);
                    if (accountData != null) {
                        bVar.f23576a.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            bVar.f23578c.setVisibility(0);
                        }
                        if (this.f23573f) {
                            bVar.f23579d.setVisibility(0);
                        }
                    }
                }
                layoutMode = this.f23572e.getLayoutMode();
            } catch (Exception e2) {
                BdLog.detailException(e2);
                layoutMode = this.f23572e.getLayoutMode();
            }
        } catch (Throwable th) {
            this.f23572e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f23572e.getLayoutMode().j(view);
            throw th;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
