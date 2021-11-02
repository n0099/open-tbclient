package b.b.a.a.c;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Uri f30033a;

    /* renamed from: b  reason: collision with root package name */
    public String f30034b;

    /* renamed from: c  reason: collision with root package name */
    public String f30035c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f30036d;

    /* renamed from: e  reason: collision with root package name */
    public String f30037e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f30038f;

    /* renamed from: g  reason: collision with root package name */
    public ContentValues f30039g;

    /* renamed from: h  reason: collision with root package name */
    public CancellationSignal f30040h;

    /* renamed from: i  reason: collision with root package name */
    public a f30041i;
    public long j;

    public b() {
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "RequestInfo{uri=" + this.f30033a + ", fileOpenMode='" + this.f30034b + ExtendedMessageFormat.QUOTE + ", mimeType='" + this.f30035c + ExtendedMessageFormat.QUOTE + ", opts=" + this.f30036d + ", where='" + this.f30037e + ExtendedMessageFormat.QUOTE + ", selectionArgs=" + Arrays.toString(this.f30038f) + ", values=" + this.f30039g + ", cancellationSignal=" + this.f30040h + ", requestCallback=" + this.f30041i + ", timeStamp=" + this.j + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
