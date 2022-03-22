package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Snapshot {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Connection> mConnections;
    public int mHeight;
    public int mWidth;
    public int mX;
    public int mY;

    /* loaded from: classes.dex */
    public static class Connection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConstraintAnchor mAnchor;
        public int mCreator;
        public int mMargin;
        public ConstraintAnchor.Strength mStrengh;
        public ConstraintAnchor mTarget;

        public Connection(ConstraintAnchor constraintAnchor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constraintAnchor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAnchor = constraintAnchor;
            this.mTarget = constraintAnchor.getTarget();
            this.mMargin = constraintAnchor.getMargin();
            this.mStrengh = constraintAnchor.getStrength();
            this.mCreator = constraintAnchor.getConnectionCreator();
        }

        public void applyTo(ConstraintWidget constraintWidget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, constraintWidget) == null) {
                constraintWidget.getAnchor(this.mAnchor.getType()).connect(this.mTarget, this.mMargin, this.mStrengh, this.mCreator);
            }
        }

        public void updateFrom(ConstraintWidget constraintWidget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraintWidget) == null) {
                ConstraintAnchor anchor = constraintWidget.getAnchor(this.mAnchor.getType());
                this.mAnchor = anchor;
                if (anchor != null) {
                    this.mTarget = anchor.getTarget();
                    this.mMargin = this.mAnchor.getMargin();
                    this.mStrengh = this.mAnchor.getStrength();
                    this.mCreator = this.mAnchor.getConnectionCreator();
                    return;
                }
                this.mTarget = null;
                this.mMargin = 0;
                this.mStrengh = ConstraintAnchor.Strength.STRONG;
                this.mCreator = 0;
            }
        }
    }

    public Snapshot(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintWidget};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConnections = new ArrayList<>();
        this.mX = constraintWidget.getX();
        this.mY = constraintWidget.getY();
        this.mWidth = constraintWidget.getWidth();
        this.mHeight = constraintWidget.getHeight();
        ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
        int size = anchors.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mConnections.add(new Connection(anchors.get(i3)));
        }
    }

    public void applyTo(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, constraintWidget) == null) {
            constraintWidget.setX(this.mX);
            constraintWidget.setY(this.mY);
            constraintWidget.setWidth(this.mWidth);
            constraintWidget.setHeight(this.mHeight);
            int size = this.mConnections.size();
            for (int i = 0; i < size; i++) {
                this.mConnections.get(i).applyTo(constraintWidget);
            }
        }
    }

    public void updateFrom(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraintWidget) == null) {
            this.mX = constraintWidget.getX();
            this.mY = constraintWidget.getY();
            this.mWidth = constraintWidget.getWidth();
            this.mHeight = constraintWidget.getHeight();
            int size = this.mConnections.size();
            for (int i = 0; i < size; i++) {
                this.mConnections.get(i).updateFrom(constraintWidget);
            }
        }
    }
}
