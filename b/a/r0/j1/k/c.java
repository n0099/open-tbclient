package b.a.r0.j1.k;

import android.view.View;
import android.widget.TextView;
import b.a.r0.j1.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.HotTopicDetailView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f19743a;

    /* renamed from: b  reason: collision with root package name */
    public View f19744b;

    /* renamed from: c  reason: collision with root package name */
    public String f19745c;

    /* renamed from: d  reason: collision with root package name */
    public String f19746d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19747e;

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
            this.f19747e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.r0.e2.c.g(this.f19747e.f19743a, "c14391");
                this.f19747e.c();
            }
        }
    }

    public c(View view, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19743a = tbPageContext;
        this.f19744b = view;
        if (view instanceof TextView) {
            HotTopicDetailView.setWriteViewStyle((TextView) view, SkinManager.getColor(b.a.r0.j1.b.CAM_X0302));
        }
        this.f19744b.setOnClickListener(new a(this));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || WriteActivityConfig.isAsyncWriting() || this.f19745c == null) {
            return;
        }
        String format = StringUtils.isNull(this.f19746d) ? null : String.format(TbadkCoreApplication.getInst().getString(h.hot_topic_detail_write_name), this.f19746d);
        WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f19743a.getPageActivity());
        newInstance.setIntentAction(IntentAction.ActivityForResult);
        newInstance.setRequestCode(25065);
        newInstance.setType(9).setForumId("0").setTopicId(String.valueOf(this.f19745c)).setFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL).setCallFrom("1").setTitle(format).send();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f19746d = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f19745c = str;
        }
    }
}
