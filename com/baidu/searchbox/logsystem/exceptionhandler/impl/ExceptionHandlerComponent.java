package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ik1;
import com.baidu.tieba.kk1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public kk1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        ik1 b = ik1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
