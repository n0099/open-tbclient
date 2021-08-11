package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes4.dex */
public class MergePathsContent implements PathContent, GreedyContent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Path firstPath;
    public final MergePaths mergePaths;
    public final String name;
    public final Path path;
    public final List<PathContent> pathContents;
    public final Path remainderPath;

    /* renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-71420717, "Lcom/airbnb/lottie/animation/content/MergePathsContent$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-71420717, "Lcom/airbnb/lottie/animation/content/MergePathsContent$1;");
                    return;
                }
            }
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mergePaths};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.firstPath = new Path();
        this.remainderPath = new Path();
        this.path = new Path();
        this.pathContents = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            this.name = mergePaths.getName();
            this.mergePaths = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    private void addPaths() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            for (int i2 = 0; i2 < this.pathContents.size(); i2++) {
                this.path.addPath(this.pathContents.get(i2).getPath());
            }
        }
    }

    @TargetApi(19)
    private void opFirstPathWithRest(Path.Op op) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, op) == null) {
            this.remainderPath.reset();
            this.firstPath.reset();
            for (int size = this.pathContents.size() - 1; size >= 1; size--) {
                PathContent pathContent = this.pathContents.get(size);
                if (pathContent instanceof ContentGroup) {
                    ContentGroup contentGroup = (ContentGroup) pathContent;
                    List<PathContent> pathList = contentGroup.getPathList();
                    for (int size2 = pathList.size() - 1; size2 >= 0; size2--) {
                        Path path = pathList.get(size2).getPath();
                        path.transform(contentGroup.getTransformationMatrix());
                        this.remainderPath.addPath(path);
                    }
                } else {
                    this.remainderPath.addPath(pathContent.getPath());
                }
            }
            PathContent pathContent2 = this.pathContents.get(0);
            if (pathContent2 instanceof ContentGroup) {
                ContentGroup contentGroup2 = (ContentGroup) pathContent2;
                List<PathContent> pathList2 = contentGroup2.getPathList();
                for (int i2 = 0; i2 < pathList2.size(); i2++) {
                    Path path2 = pathList2.get(i2).getPath();
                    path2.transform(contentGroup2.getTransformationMatrix());
                    this.firstPath.addPath(path2);
                }
            } else {
                this.firstPath.set(pathContent2.getPath());
            }
            this.path.op(this.firstPath, this.remainderPath, op);
        }
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void absorbContent(ListIterator<Content> listIterator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, listIterator) == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            while (listIterator.hasPrevious()) {
                Content previous = listIterator.previous();
                if (previous instanceof PathContent) {
                    this.pathContents.add((PathContent) previous);
                    listIterator.remove();
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.path.reset();
            if (this.mergePaths.isHidden()) {
                return this.path;
            }
            int i2 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[this.mergePaths.getMode().ordinal()];
            if (i2 == 1) {
                addPaths();
            } else if (i2 == 2) {
                opFirstPathWithRest(Path.Op.UNION);
            } else if (i2 == 3) {
                opFirstPathWithRest(Path.Op.REVERSE_DIFFERENCE);
            } else if (i2 == 4) {
                opFirstPathWithRest(Path.Op.INTERSECT);
            } else if (i2 == 5) {
                opFirstPathWithRest(Path.Op.XOR);
            }
            return this.path;
        }
        return (Path) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, list2) == null) {
            for (int i2 = 0; i2 < this.pathContents.size(); i2++) {
                this.pathContents.get(i2).setContents(list, list2);
            }
        }
    }
}
