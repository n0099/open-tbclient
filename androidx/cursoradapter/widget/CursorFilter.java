package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CursorFilter extends Filter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CursorFilterClient mClient;

    /* loaded from: classes.dex */
    public interface CursorFilterClient {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    public CursorFilter(CursorFilterClient cursorFilterClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursorFilterClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mClient = cursorFilterClient;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.mClient.convertToString((Cursor) obj) : (CharSequence) invokeL.objValue;
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence)) == null) {
            Cursor runQueryOnBackgroundThread = this.mClient.runQueryOnBackgroundThread(charSequence);
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (runQueryOnBackgroundThread != null) {
                filterResults.count = runQueryOnBackgroundThread.getCount();
                filterResults.values = runQueryOnBackgroundThread;
            } else {
                filterResults.count = 0;
                filterResults.values = null;
            }
            return filterResults;
        }
        return (Filter.FilterResults) invokeL.objValue;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, charSequence, filterResults) == null) {
            Cursor cursor = this.mClient.getCursor();
            Object obj = filterResults.values;
            if (obj == null || obj == cursor) {
                return;
            }
            this.mClient.changeCursor((Cursor) obj);
        }
    }
}
