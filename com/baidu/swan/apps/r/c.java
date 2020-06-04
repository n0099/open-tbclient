package com.baidu.swan.apps.r;

import android.os.Bundle;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.swan.apps.r.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes11.dex */
public class c extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final File cgl;

    public c(File file) {
        super("dump");
        this.cgl = file;
    }

    @Override // com.baidu.swan.apps.r.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        com.baidu.swan.apps.v.c.a lk = com.baidu.swan.apps.v.c.a.lk(bundle.getString("launch_id"));
        lk.ahk().ln("DumpFileProcessor").fG(1);
        WritableByteChannel writableByteChannel = null;
        try {
            writableByteChannel = Channels.newChannel(new FileOutputStream(this.cgl, false));
            a(sourceChannel, writableByteChannel);
            lk.bt("DumpFileProcessor", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            return true;
        } catch (IOException e) {
            lk.bt("DumpFileProcessor", "done with exception: " + e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        } finally {
            com.baidu.swan.apps.aq.b.b.a(sourceChannel);
            com.baidu.swan.e.d.closeSafely(writableByteChannel);
        }
    }

    private void a(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        if (readableByteChannel != null && writableByteChannel != null) {
            ByteBuffer allocate = ByteBuffer.allocate(32768);
            while (readableByteChannel.read(allocate) != -1) {
                allocate.flip();
                writableByteChannel.write(allocate);
                allocate.clear();
            }
        }
    }
}
