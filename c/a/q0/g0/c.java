package c.a.q0.g0;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends c.a.q0.g0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NestedScrollView f13414a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f13415b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f13416c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13417d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13418e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f13419f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f13420g;

    /* renamed from: h  reason: collision with root package name */
    public int f13421h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f13422i;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13423e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13423e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13423e.a(-1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13421h = 0;
        this.f13422i = new Rect();
        this.f13414a = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.f13415b = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.f13416c = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f13417d = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f13418e = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f13420g = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f13419f = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        c.a.q0.s.f0.n.a aVar = new c.a.q0.s.f0.n.a();
        this.f13419f.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f13419f.setTextSize(R.dimen.tbds42);
        this.f13419f.setConfig(aVar);
        this.f13419f.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (this.f13421h <= 0) {
                this.f13421h = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            NestedScrollView nestedScrollView = this.f13414a;
            if (nestedScrollView == null) {
                return;
            }
            if (i2 == 0) {
                nestedScrollView.post(new a(this));
            }
            if (this.f13414a.getLocalVisibleRect(this.f13422i)) {
                int i3 = this.f13422i.bottom;
                int abs = Math.abs(this.f13415b.getTop());
                int abs2 = i3 - Math.abs(this.f13415b.getBottom());
                ViewGroup.LayoutParams layoutParams = this.f13415b.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i4 = this.f13421h;
                    if (abs < i4) {
                        marginLayoutParams.topMargin = i4;
                        this.f13415b.setLayoutParams(marginLayoutParams);
                    } else if (abs == i4) {
                        if (abs2 > i4) {
                            marginLayoutParams.topMargin = i4 + ((abs2 - i4) / 2);
                            this.f13415b.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > i4) {
                        if (abs2 < i4) {
                            marginLayoutParams.topMargin = i4;
                        } else if (abs2 == i4) {
                            marginLayoutParams.topMargin = i4;
                        } else if (abs2 > i4) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.f13415b.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.attachedView : (View) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null) {
            return;
        }
        this.f13419f.setText(str);
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str == null) {
                this.f13417d.setVisibility(8);
                return;
            }
            this.f13417d.setVisibility(0);
            this.f13417d.setText(str);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null) {
            return;
        }
        this.f13418e.setText(str);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f13419f.setVisibility(0);
            this.f13418e.setVisibility(0);
            SkinManager.setViewTextColor(this.f13417d, R.color.CAM_X0109, 1);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f13416c, R.drawable.new_pic_emotion_08);
            SkinManager.setViewTextColor(this.f13417d, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f13418e, R.color.CAM_X0107, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            TBSpecificationBtn tBSpecificationBtn = this.f13419f;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    @Override // c.a.q0.g0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // c.a.q0.g0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onViewDettached();
            this.f13416c.setImageResource(0);
        }
    }
}
