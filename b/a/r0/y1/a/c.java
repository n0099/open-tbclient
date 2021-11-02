package b.a.r0.y1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.e.e.p.k;
import b.a.q0.s.s.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BubbleListData.BubbleData f27260f;

        public a(e eVar, BubbleListData.BubbleData bubbleData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bubbleData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27259e = eVar;
            this.f27260f = bubbleData;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                e eVar = this.f27259e;
                if (eVar != null) {
                    eVar.a(this.f27260f.getBcode());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27261e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27261e = eVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                e eVar = this.f27261e;
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
    }

    /* renamed from: b.a.r0.y1.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1341c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27262e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BubbleListData.BubbleData f27263f;

        public C1341c(e eVar, BubbleListData.BubbleData bubbleData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bubbleData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27262e = eVar;
            this.f27263f = bubbleData;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                e eVar = this.f27262e;
                if (eVar != null) {
                    eVar.a(this.f27263f.getBcode());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27264e;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27264e = eVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                e eVar = this.f27264e;
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i2);

        void b();
    }

    public static void a(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, bubbleData, eVar) == null) || bubbleData == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(tbPageContext.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        Date date = new Date();
        Date date2 = new Date(date.getTime() + (bubbleData.getTime_interval() * 1000));
        String dateStringDay = k.getDateStringDay(date);
        String dateStringDay2 = k.getDateStringDay(date2);
        String format = String.format(tbPageContext.getResources().getString(R.string.bubble_free_dialog_text), bubbleData.getBname(), Integer.valueOf(bubbleData.getTime_interval() / 86400));
        View inflate = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tip1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tip2);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0108, 1);
        textView.setText(format);
        textView2.setText(dateStringDay + tbPageContext.getString(R.string.to) + dateStringDay2);
        aVar.setContentView(inflate);
        aVar.setPositiveButton(R.string.use_immediately, new a(eVar, bubbleData));
        aVar.setNegativeButton(R.string.cancel, new b(eVar));
        aVar.create(tbPageContext);
        aVar.show();
    }

    public static void b(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, bubbleData, eVar) == null) || bubbleData == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(tbPageContext.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setMessage(String.format(tbPageContext.getString(R.string.bubble_pay_dialog_text), bubbleData.getLevel_name()));
        aVar.setPositiveButton(R.string.open_now, new C1341c(eVar, bubbleData));
        aVar.setNegativeButton(R.string.cancel, new d(eVar));
        aVar.create(tbPageContext);
        aVar.show();
    }
}
