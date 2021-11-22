package b.a.q0.s.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes4.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14206a;

    /* renamed from: b  reason: collision with root package name */
    public long f14207b;

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f14206a = jSONObject.optString("book_id", "0");
            this.f14207b = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
            jSONObject.optInt("book_type", 0);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void b(BookThread bookThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bookThread) == null) || bookThread == null) {
            return;
        }
        this.f14206a = bookThread.book_id;
        this.f14207b = bookThread.chapter_id.longValue();
        bookThread.book_type.intValue();
    }
}
